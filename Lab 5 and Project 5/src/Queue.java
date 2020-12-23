import java.util.ArrayList;

//this class will use the LinkedList class, and will only allow the use add to tail and remove from head feature that will make this linkedlist become a Queue, which is FIFO
public class Queue {
	//I will create a linked list attribute here
	LinkedList<Customer> queue=new LinkedList<Customer>();
	
	
	
	//The constructor will set the size to zero
	public Queue(){
		;
	}
	
	
	//this is the add method, this will add the Customer to the tail of the queue
	public void add(Customer c){
		this.queue.addLast(c);//We only want to add it to the end because this is a queue which is FIFO
	}
	//this method will remove a Customer form the beginning of the queue
	public void remove(){
		//no input is necessary since we are always going to remove from the head:the first element
		try{
			this.queue.remove(0);
			
		}
		catch(java.lang.NullPointerException e){
			return;
		}
	}
	//This will get the size. This should be done here since the LinkedList class will just be in the background and will only interact with the program through the Queue class
	public int getSize(){
		return this.queue.getCounter();
	}
	//We want to return the list because the Customer needs to be able to access the queue in order to run its logic
	public ArrayList<Customer> getQueue(){
		ArrayList<Customer>customers = new ArrayList<Customer>();
		
		//This will iterature through the queue and get all the Customers
		for(Customer c:this.queue){
			customers.add(c);
		}
		return customers;
	}
	
	
	
	//this is the update state, this method will actually be called in the Checkout Class, where the entire checkout will be updated
	public Customer updateState(){
		//The goal here will be to make it so that the Customer loses one item every turn and leaves the line once they have no more items
		//This will be done by incrementing the Customers item count and then checking to see if they have any items left
		for(Customer c:this.queue){
			c.addTotime(1);
		}
		try{
			this.queue.getHead().decrement();
			if(this.queue.getHead().getNumItems()==0){
				Customer Output=this.queue.getHead();
				this.remove();
				return Output;
			}
			
		}
		catch(java.lang.NullPointerException e){
			;
		}
		return null;
		
		
	}
	
	
	
	//Test the method
	public static void main(String[] args){
		Queue q=new Queue();
		Customer c=new Customer();
		q.add(c);
		int j=c.getNumItems();
		System.out.println(j);
		for(int i=1;i<=j;i++){	
		Customer d =q.updateState();
		System.out.println(c.getTime());
		System.out.println(d);
		}
		if(c!=null){
			if(c.getStrategy()==Customer.Strat.LINE){
				System.out.println("reached 1");
			}
			else if(c.getStrategy()==Customer.Strat.ITEM){
				System.out.println("reached 2");
			}
			else if(c.getStrategy()==Customer.Strat.RANDOM){
				System.out.println("reached 3");
			}
			else if(c.getStrategy()==Customer.Strat.RANDOM2){
				System.out.println("reached 4");
			}
		}
		
	}


	public Customer elementAt(int j) {
		return queue.getElementAt(j);
	}
	
	
}
