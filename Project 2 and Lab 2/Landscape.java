
//Adithya Shastry
//CS231
//2017-09-18
//Spatial Simulation:Game of Life


import java.util.ArrayList;//Import arraylist library in order to use in the getNeighbors() method
import java.awt.Graphics;//This import is for the draw method
public class Landscape {
	
	private int cols,rows;
	
	private Cell[][] land;
	
	public Landscape(int rows, int cols){
		this.cols=cols;
		this.rows=rows;
		
		//This statement will create a multidimensional array
		this.land=new Cell[rows][cols];
		//these for loops will populate the entire
		for(int i=0;i<this.getRows();i++){
			//This will loop through all of the rows
			//I have to include another for loop to loop through all of the columns
			for(int t=0;t<this.getCols();t++){
				Cell c1=new Cell();//By default they will be set to dead because I am not passing a parameter
				//I will create a new Cell object and add it to the location in the array
				land[i][t]=c1;
				//This will set the value of that position to c1, but since c1 is reused over and over again, the array will be the main pointer
			}
		}
	}
	public void reset(){
		//this will set all the cells in the grid to dead
		//I will attempt to use the same process as before
		for(int i=0;i<this.getRows();i++){
			//This will loop through all of the rows
			//I have to include another for loop to loop through all of the columns
			for(int t=0;t<this.getCols();t++){
				//In this nested for loop, I will try to call the Cell object and set its status to dead
				//In order to do this I will be calling the Cell object using the getCell() method 
				this.getCell(i,t).setAlive(false);//This will set the status to false
			}
		}

	}
	
	public Cell getCell(int x,int y){
		//this method will get the cell in the specific position in the array
		//The arguments for the function are there to specify the actual position in the array
		return this.land[x][y];
		
	}
	
	public int getRows(){
		//will return the number of rows 
		return this.rows;
		
	}
	
	public int getCols(){
		//will return the number of columns
		return this.cols;
		
	}
	
	public String toString(){
		//This method will print out the landscape
		String output="";//I need to make a variable here to hold and concatenate the toString() methods
		for(int i=0;i<this.getRows();i++){
			//This will loop through all of the rows
			//I have to include another for loop to loop through all of the columns
			for(int t=0;t<this.getCols();t++){
				//In this nested loop I will be able to access the toString() method of each cell 
				output=output+" "+this.land[i][t].toString();
			}
			//Once this loop runs, it means that it is ready to go to the next row
			//So I will add a new line statement
			output=output+"\n";//This will create a new line in the output
		}
		return output;
	}
	
	public ArrayList<Cell> getNeighbors(int row,int col){
		ArrayList<Cell> al=new ArrayList<Cell>();//create an arraylist object
		
		/*
		 * The idea in this nested for loop is to look at what positions exist relative to the centre.
		 * After a lot of deliberation, I found that the only values that exist relative to the center are -1,0, and 1
		 * for the rows, and -1,0, and 1 for the columns.Since the value of the center is not needed in the neighbors arraylist,it is important to 
		 * remove this from being interpreted. I did this by including an if statement that checked if the values being iterated were both equal to 0.
		 * This code can be called in a for loop later on to determine the neighbors of every cell in the game
		 */
		 int[] num=new int[]{-1,0,1};
		
		for(int t:num){
			//This will set the value for the row
			for(int i:num){
				//This will actually get the cell and add it to the list
				if(i==0 && t==0){
				;//This will pass, we don't want the center
				}
				else{
					
					try{
						//This try catch is necessary because some indices will be along the edge, and thus will not have some neighbors
						//the try catch will check for an array out of bounds error and just move onto the next index.
						int r=row+t;
						int c=col+i;
						al.add(this.land[r][c]);
					}
					catch(java.lang.IndexOutOfBoundsException e){
						;//This is similar to a pass statement in python and will just continue the code
					}
				}
			}
		}
		
		
		
		
		//Return the Array list object
		return al;
		
		
	}
	
	public void draw( Graphics g, int gridScale ) {
		// draw all the cells
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				this.land[i][j].draw(g, i*gridScale, j*gridScale, gridScale);
			}
		}
	}
	
	public void advance(){
		//this class will advance the game
		//first we need to make a new board to store the new layout
		
		Cell[][] newland= new Cell[this.getRows()][this.getCols()];
		//this will go through each of the positions in the array and set the values equal to one another
		//This is to make sure that we are actually creating a new array and not just making a pointer
		
		
		/*
		*This was the main source of the problem when it came to fixing the simulator to be able to handle the virus cell type
		*I decided to have an if statement that looks to see if the cell is a virus and acts accordingly
		*This was not done before and caused problems because the toString() method and the LandscapeDisplay classes used it to 
		*to work correctly
		*/
		
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				Cell c2;
				if (land[i][j].getVirus()) {
					 c2=new Cell(land[i][j].getAlive());
					c2.setVirus(true);
					
				}
				else{
					c2=new Cell(land[i][j].getAlive());//We are getting the alive status of the cell here
				}
				newland[i][j]=c2;//This will put the cell in that position
				
			}
		}
		
		//Now we need to iterate through all of the positions
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				newland[i][j].updateState(this.getNeighbors(i,j));
			}
		}
		
		
		this.land=newland;
		
	}
		
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Landscape l=new Landscape(4,5);//Create a new landscape object with 4 rows and 5 columns
		
		
		System.out.println(l.toString());//We should see a bunch of *
		
		
		boolean alive=true;
		
		//For some reason the below method is making every cell become alive instead of just one cell
		
		l.getCell(0,0).setAlive(alive);//Get the Cell in 0,0 and set it to alive
		System.out.println(l.getCell(0, 0).getAlive());
		l.getCell(0, 1).setAlive(true);
		l.getCell(1,0).setAlive(true);
		
		
		
		System.out.println(l.toString());//before advance()
		l.advance();
		
		
		System.out.println(l.toString());//this will check to see if the advance worked
		
		
		l.getCell(0,0).setVirus(true);
		System.out.println(l.toString());//before advance()
		
		l.advance();
		
		System.out.println(l.toString());//this will check to see if the advance worked
		
		
		//Now we will check the getNeighbors() method
		ArrayList<Cell> n=l.getNeighbors(1,1);
		int count=0;
		for(Cell a:n){
			
			if(a.getAlive()){
				count++;
					
			
			}
		
		
		}
		
		System.out.println(count);
		System.out.println(l.land[1][1].getAlive());
		//Should print 8 as the number of neighbors
		
		
		l.reset();//Should reset the land to make all Cells dead
		System.out.println(l.toString());//We should see a bunch of *
	}


}

