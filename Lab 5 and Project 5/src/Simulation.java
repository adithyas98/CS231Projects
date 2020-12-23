//This will actually simulate the store
public class Simulation {
	
	public static void main(String[] args) throws InterruptedException{
		CheckOut c=new CheckOut(5);
		
		LandscapeDisplay scape=new LandscapeDisplay(c,10);
		Statistics f=new Statistics();
		int i=0;
		while(true){
			Spawner s=new Spawner(1,c);
			s.createCustomer();
			c.updateStates();
			scape.repaint();
			Thread.sleep(250);
			i++;
			
			
		if(i%100==0 && i>1)	{
		System.out.println("The Average for the Costumers that decided based on the number of items was: "+f.Mean(f.getTimes(c.getItem()))+" The Standard Deviation was: "+f.StandardDeviation(f.getTimes(c.getItem())));
		System.out.println("The Average for the Costumers that decided based on the number of Customers was: "+f.Mean(f.getTimes(c.getLine()))+" The Standard Deviation was: "+f.StandardDeviation(f.getTimes(c.getLine())));
		System.out.println("The Average for the Costumers that Randomly decided was: "+f.Mean(f.getTimes(c.getRandom()))+". The Standard Deviation was: "+f.StandardDeviation(f.getTimes(c.getRandom())));
		System.out.println("The Average for the Costumers that Randomly picked 2 lanes and chose the best out of them was: "+f.Mean(f.getTimes(c.getRandom2()))+". The Standard Deviation was: "+f.StandardDeviation(f.getTimes(c.getRandom2())));
			
		}
		
	}

}
}
