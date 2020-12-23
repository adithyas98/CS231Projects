import java.util.ArrayList;
import java.util.Random;

//This will create customer object and assign them to a specific lane based on logic
public class Spawner {
	// I will release Customers at random depending on the density I want
	Customer customer;
	double density;// this will hold the density of Customers that are generated
	CheckOut checkout;// This is the checkout class, that will be imported in
						// the constructor to make sure all the decisions are
						// made correctly
	private int waitTime = 0;// this will hold the amount of time the costumer
								// will wait to make their decision

	public Spawner(double d, CheckOut c) {
		// this is the constructor
		this.density = d;
		this.checkout = c;

	}

	public void createCustomer() {
		Random gen = new Random();// We want to create a random object since we
									// need it to allow the correct density of
									// Customers

		if (gen.nextDouble() <= this.density && this.customer == null) {
			// I only want to create a new Customer if the spawner class isn't
			// already handling a Customer, since the Customer will take time to
			// decide
			// and only if it meets the density requirements(How popular the
			// store is)
			this.customer = new Customer();// This will create the Customer
											// object
			System.out.println(this.customer.getNumItems());
			// I will make the costumer wait for their alloted time here
			if (this.customer.getStrategy() == Customer.Strat.LINE || this.customer.getStrategy() == Customer.Strat.ITEM) {
				// If the costumer strategy is a strategy that looks at all the
				// lines
				this.waitTime = 4;

			} else if (this.customer.getStrategy() == Customer.Strat.RANDOM) {
				// This requires no thought since they are just choosing
				// randomly
				this.waitTime = 1;
				
			} else if (this.customer.getStrategy() == Customer.Strat.RANDOM2) {
				// This requires some thought therefore it should require one
				// more time step than the Random
				this.waitTime = 2;
			}

		}
		if (this.customer != null) {
			// I am including this here since I have two conditions to create a new Costumer
				this.customer.addTotime(this.waitTime);
				this.sortCustomer();
			}
	
		
		// this else statement will mean that no costumer showed up so it will just break
		else{
			return;
		}
}



	public void sortCustomer() {
		// The actual sorting will happen here
		if(this.customer.getStrategy()==Customer.Strat.ITEM){
			this.ItemSort();
		}
		else if(this.customer.getStrategy()==Customer.Strat.LINE){
			this.CustomerSort();
		}
		else if(this.customer.getStrategy()==Customer.Strat.RANDOM)	{
			this.RandomPick();
		}
		else if(this.customer.getStrategy()==Customer.Strat.RANDOM2){
			this.RandomPick2();
		}
	}

	// These methods will be called in the sort Customer method above
	public void ItemSort() {
		// this will sort based on items

		this.checkout.addCustomer(this.findMin(this.checkout.getNumItems()), this.customer);

		this.customer = null;// This must be done since it is one of the
								// conditions of entry
	}

	public void CustomerSort() {
		// this will sort based on the number Customers
		this.checkout.addCustomer(this.findMin(this.checkout.getNumCustomers()), this.customer);
		this.customer = null;
	}

	public void RandomPick2() {
		// this will make the Customer randomly pick two lines and then pick the
		// shortest one out of those
		Random gen = new Random();
		int x = gen.nextInt(this.checkout.getNumLanes());// this will hold the
															// one
															// of the two
															// randomly
															// selected lanes
		int y = gen.nextInt(this.checkout.getNumLanes());
		if (x != y) {
			// We need to make sure we don't have the same lane
			if (x <= y) {
				this.checkout.addCustomer(x, this.customer);
			} else {
				// the only option here is for y<x
				this.checkout.addCustomer(y, this.customer);
			}
		} else {
			this.RandomPick();
		}
		this.customer = null;
	}

	public void RandomPick() {
		// this will just randomly select a queue to enter
		Random gen = new Random();
		this.checkout.addCustomer(gen.nextInt(this.checkout.getNumLanes()), this.customer);// this
																							// will
																							// add
																							// the
																							// costumer
																							// to
																							// the
																							// randomly
																							// chosen
																							// line
	}

	public int findMin(ArrayList<Integer> al) {
		// this method will find the minimum value of the list
		int index = 0;
		int minValue = al.get(index);// We want to start by checking the first
										// value

		for (int i = 1; i < al.size(); i++) {
			if (al.get(i) <= minValue) {
				// If a new minimum value is found
				minValue = al.get(i);
				index = i;
			}
		}

		return index;
	}

}
