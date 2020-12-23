//Adithya Shastry
//CS231
//2017-09-18
//Spatial Simulation:Game of Life
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;//For the draw method

public class Cell {
	//This boolean will hold the value for the Cell's status
	//the Cell is alive if the value for the boolean is true
	boolean alive;
	







	boolean virus;//This virus boolean will check to see if the cell is a virus
	
	
	public boolean getVirus(){
	//this method will check to see if the cell is a virus or not
		return this.virus;
	
	}
	
	public void setVirus(boolean virus){
		this.virus=virus;
		if(virus){
			//If this is a virus then the cell is really dead
			this.alive=false;
		
		}
	
	}
	





	
	
	
	public Cell(){
		//This is the base constructor method to dead
		this.alive=false;
		
	}
	
	//This method will allow for an argument that will set the status to what ever is actually inputed as an argument
	public Cell(boolean alive){
		this.alive=alive;
		
	}
	
	//This method will return whether the Cell is alive
	public boolean getAlive(){
		return this.alive;
	}
	
	//This method will set the status of the Cell
	public void setAlive(boolean alive){
		this.alive=alive;
	}
	
	
	//This method will print the status of the Cell to a string
	//Since this method will usually be called in the toString() method of the landscape class, I will have to set the value accordingly
	public String toString(){

		if(this.alive){
			return "O";
			//This if statement will check to see if the Cell is actually alive, if it is we want it to return a value of O, resembling a Cell
		}
		else if(this.virus){
	
			return"+";
		
		}
		else{
			//The only other option is for this.alive to be false in which case we return an empty string
			return "*";
		}
	}
	public void draw(Graphics g, int x, int y, int scale){
	//This will set the colour to a specific colour depending on the status of the Cell
		if(this.getAlive()){
			g.setColor(Color.BLACK);
		}
		else{
			if(this.getVirus()){
			
				g.setColor(Color.green);
			}
			else{
				g.setColor(Color.WHITE);
			}
		}
		//This will draw the Cell
		
		
		g.fillRect(x, y, scale, scale);
	}
	
	
	public void updateState(ArrayList<Cell> neighbors){
		//First I will loop through and find all the neighbors that are alive and count them
		int count=0;
		int vcount=0;
		for(int i=0;i<neighbors.size();i++){
			if(neighbors.get(i).getAlive()){
			//This will only add it if the cell is alive
			
				count=count+1;
		
			}
			else{
		
				//System.out.println("else");
				//Here we have to check if the cell is a virus since it is technically dead
				if(neighbors.get(i).getVirus()){
					//System.out.println("Counting viruses");
				
					vcount++;
			
				}
			
			
			
		
			}
		}
		//We will split the logic into two: one for live cells and one for dead cells
		
		if(this.getAlive()){
			if(count<2){
				//This will return a false since the Cell should die
				this.setAlive(false);
	
			}
	
			else if(count>=2 && count<=3){
				;//Nothing will be done here, if the Cell is dead it will continue to be dead,
				//if alive it will continue to be alive.Thus, there is nothing to change here
	
			}
		
				else if(count>3){
				this.setAlive(false);
				//Overpopulation
		
				}
		}
		
	
		
		else{//If the cell is dead
		
			if(count == 3){
			
	
				this.setAlive(true);
				//this will come back to life!
		
			}
			
		
		}
		
		
		
	
			
			
		//I will let these commands run, and then check to see if the Cell has a neighbor that is a virus
		if(vcount>=1 || this.getVirus()){
			//This means there is a virus or the cell itself is a virus
			//The cell will be set to dead and will turn into a virus
			this.setAlive(false);

			this.setVirus(true);
	
		
		}
	
	}

	public static void main(String[] args) {
		//This code will test to see if the methods stated above actually work
		Cell c1=new Cell();//This one has no parameters and should be set to dead
		System.out.println(c1.toString());
		System.out.println(c1);
		Cell c2=new Cell(true);//In this one we are sending a value of true, which should return an O in the next line.
		System.out.println(c2.toString());
		c2.setVirus(true);
		System.out.println(c2.toString());//Checks if the virus is working correctly
		//Now I will check the setAlive method to see if the status will change when I set a different value
		c1.setAlive(true);//This should make the Cell alive
		System.out.println(c1.toString());//this should print an O.

		
		
		
		
		

	}

}
