import java.util.ArrayList;

//This will handle the statistics of the simulation

public class Statistics {
	public Statistics(){
		;
	}
	//This method can be used in the methods below where the times are necessary
	public ArrayList<Integer> getTimes(ArrayList<Customer> customers){
		ArrayList<Integer> times = new ArrayList<Integer>();
		for(Customer c: customers){
			times.add(c.getTime());
		}
		return times;
	}
	
	public double Mean(ArrayList<Integer> c){
		//this will find the mean of the list
		double sum=0;
		for(Integer x:c){
			sum=sum+x;
		}
		//Once the sum is found then divide it by the size of the list
		return (double) (sum/c.size());
	}
	public double StandardDeviation(ArrayList<Integer>c){
		//Finding the mean
		
		double mean=this.Mean(c);
		
		//Subtract the mean from every value and square it, then sum it with the others
		double y=0;
		for(Integer x:c){
			y=y+Math.pow((x-mean), 2);
		}
		
		
		//divide it by the number of items then Take the Square root
		
		
		return Math.sqrt((y/c.size()));
		
		
		
	}
}


