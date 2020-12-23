import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class ParkingSimulation {

	public void run(double probabilityToPark, int timeStep) throws InterruptedException {
		int i = 0; // this will be used to run the game
		// Create a parking Garage
		ParkingGarage pg = new ParkingGarage(3, 10);
		
		ParkingDisplay display=new ParkingDisplay(pg,30);
		
		ArrayList<Integer>avgCarsLane=new ArrayList<Integer>();//This will hold the average number of cars per lane for the game

		// Initialize other variables
		int rejCars = 0;// This is the number of cars that were rejected
		int accCars = 0;// Number of cars accepted

		// Create the random object
		Random randy = new Random();
		randy.setSeed(System.currentTimeMillis());

		// The ArrayList of cars is maintained in the ParkingGarage class

		while (i < timeStep) {

			// Generate Cars and try to park them
			for (int x = 0; x < 2; x++) {// This will possibly create two cars
				if (randy.nextDouble() <= probabilityToPark) {
					Car c = new Car(i + 1 + randy.nextInt(timeStep-i),//This is to make sure the cars would be able to leave in the future
							new Color(randy.nextFloat(), randy.nextFloat(), randy.nextFloat()));// Creating
																								// a
																								// random
																								// car
					if (pg.parkCar(c)) {
						// If the car is parked
						accCars++;
					} else {
						// the car wasn't parked
						rejCars++;
					}
				}
			}
			
			
			
			
			

			// Loop through the master list to see if any car needs to be retrieved

			for (int x=0;x<pg.masterList().size();x++) {
				if(pg.masterList().get(x).getTimeToLeave()==i){//Since i is the value I am using to represent the time, i should be used to do compare the time to leave to leave
					//If it has to leave then I need to retrieve the car
					pg.retrieveCar(pg.masterList().get(x));//this will retrieve the car from the parking garage
					break;
					//the car will be deleted from the ArrayList in the Parking garage Class
				}
			}
			i++;
			Thread.sleep(250);
			display.repaint();
			
			
			for(CarStack lane:pg.lanes){
				avgCarsLane.add(lane.size());//This will add the number of cars per lane for every timestep.
			}

		}

			// generate the Statistics
		
			double AvgCars=0.0;
			double sum=0.0;
			for(int a:avgCarsLane){
				sum=sum+(double) a;//This will sum the entire list
			}
			
			AvgCars=(sum/(avgCarsLane.size()));//This will make an output that is the average cars per lane 
			
			double acceptanceRate=((double)accCars/(accCars+rejCars));//This represents the rate at which cars were parked
			System.out.println(rejCars+" were rejected");
			System.out.println(accCars+" Cars were parked");
			System.out.println("There was an Parking rate of "+ acceptanceRate);
			System.out.println("This is the number of times the Holding Space was used: "+pg.getNumHold());//This will return the number of times numHold was used
			System.out.println("The lanes held "+AvgCars+" on average throughout the simulation!");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ParkingSimulation ps=new ParkingSimulation();
		ps.run(0.5,100);
	}

}
