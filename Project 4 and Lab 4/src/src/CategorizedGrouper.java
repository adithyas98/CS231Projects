import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class CategorizedGrouper extends Grouper {
	private int category;
	private double moveRange=20;
	
	public CategorizedGrouper (double x0,double y0, int cat){
		super(x0,y0);
		this.category=cat;
	}


	public int getCategory() {
		return category;
	}
	public String toString(){
		return"The category of this Categorized Grouper is"+this.getCategory();
	}
	public void draw(Graphics g){
			Color c=new Color(10*((this.category)),10*((this.category)),10*((this.category)));
			// if(this.category==1){
// 			
// 				g.setColor(Color.RED);
// 			}
// 			else if(this.category==2){
// 				g.setColor(Color.BLUE);
// 			}
// 			else{
// 				g.setColor(Color.ORANGE);
// 			}
			g.setColor(c);
			g.fillOval((int)this.getX0(),(int) this.getY0(), 5, 5);//This will draw the object with the specified colour
			System.out.println(g.getColor());
	}
	@Override//This should override the original method in the java
	public void updateState(Landscape scape){
		ArrayList<Agent> neighbors= scape.getNeighbors(this.getX0(),this.getY0(),this.moveRange);
		//here I will take neighbors and only take their categories
		ArrayList<Integer> categories=new ArrayList<Integer>();
		for(Agent x:neighbors){
			categories.add(x.getCategory());
		}
		
		//here I will create an algorithm that will find the mode of the arraylist of categories
		//These values will be required to run the method.
		int maxCount=0;//this will hold the frequency of the most common category in the list
		int maxCountValue=0;//This will hold the actually value of the mode
		int count=0;//This will be an intermediary variable that will be used to compare to previous values.
		//Now I will start the actual algorithm
		
		for(int a:categories){
			for(int b:categories){
				if(a==b){
					count++;//this will add one to the count if the values are equal
					
				}
				
			}
			if(maxCount<count){
				//If the maxCount is less than count then make the max count equal to the count
				maxCount=count;
				//We also want to return the value being checked
				maxCountValue=a;
			}
			
		}
		/*
		 * The general idea here is to take all the values of the arraylist and compare them to all the other values of the arraylist. 
		 * Then based on the frequency of the category values, a new max count will be created. When this variable is changed the value 
		 * of the mode must also change because there is a new mode.This algorithm should effectively find the mode of the list.
		 */
		
		//Create a random object
		Random gen=new Random();
		
		//Now I will actually mode the categorizedGrouper based on the rules
		if(maxCountValue==this.category){
			//If the category is the most common one, then it will move with a chance of 0.01
			if(gen.nextDouble()<=0.01){
				this.move(this.moveRange,scape);
			}
			
		}
		
		else{
			this.move(this.moveRange,scape);
		}
		
	}



}



