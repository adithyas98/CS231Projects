import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/*
	 * Parking Cars
	 * CS231
	 * Adithya Shastry
	 * Project 3
	 * 
	 * This Class will represent the Parking garage and will have an ArrayList of CarStacks that will represent the lanes and the number of spots in those
	 * lanes respectively.
	 */
public class ParkingGarage {
	private int numLanes;// This will hold the number of lanes in the parking
							// garage
	private int numSpots; // this will hold the number of spots to include in
							// the CarStack object
	ArrayList<CarStack> lanes = new ArrayList<CarStack>();// Creating an array
															// to store the
															// lanes(CarStack
															// objects)
	ArrayList<Car> cars = new ArrayList<Car>();// This will hold a master list
												// of all cars so that the
												// program can check one place
												// to find out information on
												// When the car should leave
	ArrayList<Car> holding = new ArrayList<Car>();// This is the holding area
													// for cars that are being
													// taken out to park other
													// cars
	int numhold=0;

	public ParkingGarage(int numLanes, int numSpots) {
		// I need to set the variables to the input
		this.numLanes = numLanes;
		this.numSpots = numSpots;
		// Now to initialize the ArrayList of CarStack objects using the
		// numLanes and numSpots variables
		for (int i = 0; i < this.numLanes; i++) {
			CarStack c1 = new CarStack(this.numSpots);// Here a CarStack object
														// is created with
														// specified number of
														// spots
			lanes.add(c1);// The CarStack is added(The lanes are added)
		}
	}

	public int getMaxLanes() {
		return this.numLanes;// Will return the number of lanes
	}

	public int getMaxSpots() {
		return this.numSpots;// Will return the max number of spots
	}

	// This method will park the car
	public boolean parkCar(Car car) {
		// First we will check to see if a car can actually be parked
		// this will be done by going through the arraylist of lanes and calling
		// the isFull() method on the CarStack
		boolean carparked = false;// This will be used to see if the car is
									// parked and to run the while loop
		int i = 0;
		while (i < this.getMaxLanes() && !carparked) {
			if (!(this.lanes.get(i).isFull())){
				this.lanes.get(i).push(car);// This will park the car
				this.cars.add(car);// This is the master list of cars
				// Now I will set the location of the car so that it is easier
				// to retrieve
				car.setLaneNumber(i);// This will set the lane number of the
										// car, which is i in this case
				car.setLanePosition(this.lanes.get(i).getTop() - 1);// I am
																	// subtracting
																	// one
																	// because
																	// the value
																	// of top is
																	// pointing
																	// to the
																	// next open
																	// spot
				/*
				 * Through the use of the location numbers above, it will be
				 * much easier to retrieve the car from its parked position, by
				 * using the getter methods when it is time to take the car out
				 */
				// The car will also be added to the master list of cars

				carparked = true;// We need to break the loop
				// Don't need to iterate i because the loop will break anyways
			} else {
				carparked = false;// It is by default false, but this will just
									// make sure
				i++;

			}
			// i would be deleted after this method is run, since it is a local
			// variable

		}
		// This would mean that one of the above statements was broken and
		// therefore the value of carparked should be returned.
		return carparked;

		// Once carparked is used, it is deleted, because it won't be called
		// anymore outside of the function
	}
	/*
	 * The general idea of this logic is to run while both the value of i is
	 * less than the max lanes and the value of carparked is false. Once one of
	 * these conditions are met the while loop will break. These conditions
	 * seemed to be the two conditions that would be needed to complete the
	 * parking process For example, if only the value of carparked value was
	 * used to do the while loop, then the while loop would run forever if there
	 * were no spots in the garage. This is why the other statement was included
	 * in the logic of the method.
	 */

	@Override
	public String toString() {
		return "There are " + this.cars.size() + " cars parked in the parking garage and " + this.holding.size()
				+ " of those cars are in the holding area.";
	}

	public void retrieveCar(Car car) {
		int lane = car.getLaneNumber();// this will retrieve the lane the car is
										// in
		int spot = car.getLanePosition();// This will retrieve the lane position
											// the car is in.

		// Now the idea is to create a method with which the car can use the top
		// variable of the car stack and use that to pop the cars in the stack
		// that are above the index of the car we want to retrieve
		int newtop = this.lanes.get(lane).getTop() - 1;
		// This will return the
		// number of the top
		// value in the stack.
		// We need to subtract
		// one because the top
		// value is referring to
		// the next open spot
		// which is not what we
		// need.

		// Now the idea is to remove the cars above the car we want to retrieve
		while (newtop != spot) {
			this.holding.add(lanes.get(lane).pop());
			// this will remove the car
			// from the Car Lane and add
			// it to the holding area

			// We want to stop right before the value gets to the spot we want
			// because we actually want to remove this from the list and not add
			// it to the holding area
			newtop--;// we need to iterate newtop.Since newtop cannot be less than spot,because then it wouldn't exist

			// newtop is going to be deleted after this loop since it won't be
			// used anymore.
		}
		this.lanes.get(lane).pop();// We know that this will be the car we

		// Data is deleted here

		// want to retrieve
		for (int i = 0; i < this.cars.size(); i++) {
			if (this.cars.get(i) == car) {
				this.cars.remove(i);// This will remove the cars from the master
									// list
			}
		}
		// Now we need to add back the cars
		for (int i = this.holding.size() - 1; i >= 0; i--) {
			// We want to
			// subtract one from
			// the .size()
			// method because
			// the index will be
			// one less than the
			// number of
			// elements.
			this.lanes.get(lane).push(this.holding.remove(i));
			this.numhold++;//Iterate the numhold value because 
			/*
			 * This will remove the element with the specified index from the
			 * list and add it to the lane(CarStack)
			 */
		}
		// the integers spot and lane will be deleted since references to it
		// won't be needed outside of the method.
	}
	
	public int getNumHold(){
		return this.numhold;
	}

	public static void main(String[] args) {
		// I will test the methods i have implemented below:

		// Create a parking garage object
		ParkingGarage p1 = new ParkingGarage(1, 4);
		// this is a parking garage
		// with one lane and one
		// spot. I chose this
		// specifically to be able
		// to test it easily

		// Create a Car object
		Car c1 = new Car(100);
		// the color doesn't matter for this test so it
		// will be set to the default value:red

		System.out.println(p1.parkCar(c1));// This will park the car and should
											// return a true

		Car c2 = new Car(1290);
		// this will create a second car that will also
		// be parked, but should return false

		System.out.println(p1.parkCar(c2));
		// This should print false, since
		// there should'nt be any spots.
		System.out.println(p1.toString());

		// This is to check to see if the park and retrieve car methods work
		Car c10 = new Car(10, new Color(1.0f, 0.0f, 0.0f));
		Car c11 = new Car(3, new Color(0.0f, 1.0f, 0.0f));
		System.out.println(p1.parkCar(c10));
		System.out.println(p1.parkCar(c11));
		p1.retrieveCar(c1);
		System.out.println("Just retrieved a car");
		System.out.println(p1);

	}

	// This method will return the master list that was created with every car
	// in the parking lot
	public ArrayList<Car> masterList() {
		return this.cars;
	}

	public void draw(Graphics g, int gridScale) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.getMaxLanes(); i++) {
			for (int j = 0; j < this.lanes.get(i).size(); j++) {
				this.lanes.get(i).elementAt(j).draw(g, i * gridScale, j * gridScale, gridScale, gridScale);
			}
		}
	}
}
