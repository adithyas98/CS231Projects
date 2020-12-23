import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;




//this will represent the customer in the class, and will hold the logic behind choosing a lane
//These methods will be called in the spawner class that will create a Customer and 
public class Customer {
	// this will allow the program to track how long it takes the Customer to
	// leave the checkout
	private int Time;// This integer will hold the time the Customer was able to
						// leave and will be used to do the calculations
						// necessary
	// The customer will also have to know how many items they have
	private int numItems;

	// the constructor will set the timeIn and the number of Items.The number of
	// Items will be random

	public enum Strat {
		RANDOM, LINE, ITEM, RANDOM2;
	};// This enum will determine which strategy the Customer will utilize.

	private Strat strategy;

	public Customer() {
		// create a Random object
		Random gen = new Random();
		gen.setSeed(System.currentTimeMillis());
		this.numItems=10+gen.nextInt(101);
		//this.setStrategy(Strat.RANDOM2); 
		this.setStrategy(Strat.values()[gen.nextInt(Strat.values().length)]);
		this.Time = 0;
	}

	public int getNumItems() {
		return numItems;
	}

	public void decrement() {
		this.numItems = numItems-1;
	}

	public void addTotime(int i) {
		// int i will make this method more modular in that the logic methods
		// below will also be able to use it.
		this.Time = this.Time + i;
	}

	// This will return the total time spent
	public int getTime() {
		return Time;
	}

	public Strat getStrategy() {
		return strategy;
	}

	public void setStrategy(Strat strategy) {
		this.strategy = strategy;
	}

	public void draw(Graphics g, int i, int j, int gridScale, int gridScale2) {
		//this will draw the costumer
		Random gen=new Random();
		Color c=new Color(gen.nextFloat(),gen.nextFloat(),gen.nextFloat());//I did this one purpose to make the visualization more interesting.
		g.setColor(c);
		g.fillOval(i, j, gridScale, gridScale2);
		
	}

}
