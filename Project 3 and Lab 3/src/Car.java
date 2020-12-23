import java.awt.Color;//Import the color class which is used in the 
import java.awt.Graphics;

/*
 * Parking Cars
 * CS231
 * Adithya Shastry
 * Project 3
 * 
 * 
 * The car class will hold the time the car has to leave and the time the color of the car
 */
public class Car {
	// Initialize the int to hold the amount of time
	private int timeToLeave;
	private Color color;

	private int laneNumber; // this number will hold the which lane the car is
							// in so that it is easier to retrieve
	private int lanePosition;// this will hold the position of the car in the
								// lane

	public Car(int timeToLeave) {

		this.color = new Color(255, 0, 0);// This uses the RGB color scheme and
											// a value of 255 in the first
											// column will set it to Red
		this.timeToLeave = timeToLeave;// Setting the time to leave

	}

	public Car(int timeToLeave, Color color) {
		this.timeToLeave = timeToLeave;// Setting the value of the timeToLeave
										// int
		this.color = color;// Setting the object color equal to the color object
							// pointer

	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getTimeToLeave() {
		return timeToLeave;
	}

	public void setTimeToLeave(int timeToleave) {
		this.timeToLeave = timeToleave;
	}

	/**
	 * @return the laneNumber
	 */
	public int getLaneNumber() {
		return laneNumber;
	}

	/**
	 * @param laneNumber
	 *            the laneNumber to set
	 */
	public void setLaneNumber(int laneNumber) {
		this.laneNumber = laneNumber;
	}

	/**
	 * @return the lanePosition
	 */
	public int getLanePosition() {
		return lanePosition;
	}

	/**
	 * @param lanePosition
	 *            the lanePosition to set
	 */
	public void setLanePosition(int lanePosition) {
		this.lanePosition = lanePosition;
	}

	@Override
	public String toString() {
		return "The color of the car is:" + this.color + "\n The Car leaves in " + this.timeToLeave;

	}
	public void draw(Graphics g,int x,int y,int width, int height){
		g.setColor(this.getColor());
		g.fillRect(x, y, width, height);
	}

	public static void main(String[] args) {
		Car c = new Car(254);
		System.out.println(c.toString());// This should output a red color and a
											// time of 254
		Color d = new Color(20, 20, 20);
		Car c1 = new Car(23, d);
		System.out.println(c1.toString());// Should show 23 and some other color
											// respectively.

	}

}
