import java.awt.Graphics;

/*
 * Adithya Shastry
 * CS231 Fall 2017
 * Finding people Project 4
 * 
 */
public abstract class Agent {
	//This class will be used as a parent class for the different categories of groupers
	double x0;
	double y0;
	public Agent(double x0, double y0){
		this.x0=x0;
		this.y0=y0;
		
		//This will set the coordinates of the agent
	}
	public double getX0() {
		return x0;
	}
	public void setX0(double x0) {
		this.x0 = x0;
	}
	public double getY0() {
		return y0;
	}
	public void setY0(double y0) {
		this.y0 = y0;
	}
	public String toString(){
		return("("+this.getX0()+","+ this.getY0()+")");
	}
	
	//the below methods will be implemented differently in the child classes
	abstract public void updateState(Landscape scape);
	abstract public void draw(Graphics g);
	abstract public int getCategory();
	
}
