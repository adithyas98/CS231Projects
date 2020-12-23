
/*
 * Adithya Shastry
 * CS231 Fall 2017
 * Finding people Project 4
 * 
 */


import java.awt.Graphics;
import java.util.ArrayList;

public class Landscape {
	private int w;
	private int h;
	private LinkedList<Agent> agents;
	public Landscape(int w,int h){
		this.w=w;
		this.h=h;
		this.agents=new LinkedList<Agent>();
	}
	public int getWidth() {
		return w;
	}
	public int getHeight() {
		return h;
	}
	public void addAgent(Agent a){
		agents.addFirst(a);//This is meant to add the agent to the beginning of the list
	}
	public String toString(){
		return "There are "+ this.agents.getCounter()+"Agents in the landscape";
	}
	//This method will get the neighbors of the specified agent and will add it to an array list
	public ArrayList<Agent> getNeighbors(double x0,double y0,double radius){
		ArrayList<Agent> neighbors=new ArrayList<Agent>();
		//Now I will iterate through all the agents in the linked list and see where they are situated
		for(Agent a:this.agents.toArrayList()){//This will run through the agents in the landscape
			//The distance between this cell and the original cell will be calculated now
			//The square root will not be used in order to make the program more efficient instead the output will be compared to the radius squared
			//the formula being used is the distance formula 
			double distance=(Math.pow((a.getX0()-x0), 2))+(Math.pow(a.getY0()-y0, 2));
			if(distance<=Math.pow(radius, 2)){
				neighbors.add(a);//This will add the agent if it is within the radius
			}
			//There is no else statement because we only want to add the number of agents within the radius of the current agent
			//This will return the ArrayList
		
			
		}
		return neighbors;
	}
	/* draw all the agents */
	public void draw (Graphics g) {    
	    for (Agent a: this.agents) {
	        a.draw(g);
	    }
	}
	
	public void updateAgents(){
		//this method will update the agents in landscape in a random order
		for(Agent a:this.agents.toShuffledList()){
			//This will iterate through the entire shuffled list
			a.updateState(this);
		}
	}
}
