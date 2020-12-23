
/*
 * Adithya Shastry
 * CS231 Fall 2017
 * Finding people Project 4
 * 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Grouper extends Agent{
	private double friendZone=3.0;//This variable will hold the radius that is considered to be the zone the grouper can make friends in
	private double moveRange=5.0;//This variable will hold the range with which the grouper can move.
	public Grouper(double x0,double y0){
		super(x0,y0);
	}
	public void draw(Graphics g){
		g.fillOval((int)this.getX0(), (int)this.getY0(), 5, 5);
	}
	public void updateState(Landscape scape){
		int num=scape.getNeighbors(getX0(), getY0(), this.friendZone).size();//This will return the number of neighbors the cell has
		//This will create a random object that can be used to generate numbers used
		Random gen=new Random();
		//this will now be used for the logic of the program
		if(num>3){
			//If the agent has more than 3 neighbors
			if(gen.nextDouble()<0.01){
				//If there is a probability of less than 1 percent then 
				this.move(this.getMoveRange(),scape);
				return;
			}
			else{
				return;//This will exit the method
			}
		}
		this.move(this.getMoveRange(),scape);//This will move
		return;
		
	}
	public void move(double r,Landscape scape){
		Random gen=new Random();
		//Here I will write the code that will make sure the agent is moving the correct distance
		double x1=(gen.nextDouble()*10)-5;//the idea here is to shift the minimum value down to -5 and generate a double between 0 and 1 and multiply it by 10. 
		double y1=(gen.nextDouble()*10)-5;
		//Now the value of x1 and y1 will be added to x0 and y0
		
		this.setX0(this.getX0()+x1);
		this.setY0(this.getY0()+y1);
//		if(Math.abs(this.x0)>scape.getWidth()||Math.abs(this.y0)>scape.getHeight()){
//			//this will check to see if the new value for x and y is greater than the width and height of the 
//			//If this is the case, the move method must be run again
//			this.move(r, scape);
//		}
				
	}
	public double getMoveRange() {
		return moveRange;
	}
	@Override
	public int getCategory() {
		return 0;//This should never be called, but since the agent class has it it must be implemented
	}
	}



