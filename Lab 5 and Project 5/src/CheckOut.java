import java.awt.Graphics;
import java.util.ArrayList;

//This class will hold a list of checkouts and manage the update states of the Queues
//This class is meant to simulate the entire checkout part of the store, not just one checkout line
public class CheckOut {
	//This will create an arraylist of queues
	private ArrayList<Queue> checkout=new ArrayList<Queue>();
	
	private ArrayList<Customer> Line=new ArrayList<Customer>();
	private ArrayList<Customer> Item=new ArrayList<Customer>();
	private ArrayList<Customer> Random=new ArrayList<Customer>();
	private ArrayList<Customer> Random2=new ArrayList<Customer>();
	
	//the constructor
	public CheckOut(int numLanes){
		//This will initialize the checkout class
		//numLanes will hold the number of lanes in the checkout
		for(int i=0;i<numLanes;i++){
			//This will loop through and create the number of lanes needed to be created, specified by the input parameter
			Queue q1=new Queue();//Queue does not take any parameters
			this.checkout.add(q1);//this will add the queue object to the checkout list
		}
	}
	
	
	//This will get the number of Customers in each queue and output it into an arraylist
	public ArrayList<Integer> getNumCustomers(){
		ArrayList<Integer> output=new ArrayList<Integer>();
		for(Queue q:checkout){
			output.add(q.getSize());//this will get the size of the queue and add it to the list
		}
		return output;
	}
	
	
	
	//This will get the items in each queue and put them into an arraylist
	public ArrayList<Integer> getNumItems(){
		ArrayList<Integer> output=new ArrayList<Integer>();
		//I cannot think of another way to to this without the use of a nested for loop
		for(Queue q:this.checkout){
			int totalItems=0;
			for(Customer c:q.getQueue()){
				totalItems=totalItems+c.getNumItems();
			}
			output.add(totalItems);
			
		}
		return output;
	}
	
	
	
	
	//this will update the state of the entire checkout by iterating through the list of queues
	
	public void updateStates(){
		for(Queue q:this.checkout){
			//This will iterate through the lanes
			
			Customer c=q.updateState();
			
			if(c!=null){
				
				if(c.getStrategy()==Customer.Strat.LINE){
					this.Line.add(c);
				}
				else if(c.getStrategy()==Customer.Strat.ITEM){
					this.Item.add(c);
				}
				else if(c.getStrategy()==Customer.Strat.RANDOM){
					this.Random.add(c);
				}
				else if(c.getStrategy()==Customer.Strat.RANDOM2){
					this.Random2.add(c);
				}
			}
			
		}
	}
	
	public void addCustomer(int index,Customer c){//This method will be called in the Spawner class
		//this method will call the add method in the queue, based on what line the Customer needs to enter
		this.checkout.get(index).add(c);
	}
	


	public int getNumLanes() {
		return this.checkout.size();
	}


	
	
	
//This is the draw method
	public void draw(Graphics g, int gridScale) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.getNumLanes(); i++) {
			for (int j = 0; j < this.checkout.get(i).getSize(); j++) {
				this.checkout.get(i).elementAt(j).draw(g, i * gridScale, j * gridScale, gridScale, gridScale);
			}
		}
	}


	public ArrayList<Customer> getLine() {
		return Line;
	}





	public ArrayList<Customer> getItem() {
		return Item;
	}





	public ArrayList<Customer> getRandom() {
		return Random;
	}




	public ArrayList<Customer> getRandom2() {
		return Random2;
	}



	
	
	
	
	

}
