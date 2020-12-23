import java.util.Random;

/*
 * Adithya Shastry
 * CS231 Fall 2017
 * Finding people Project 4
 * 
 */

public class GrouperSimulation {
	public void run(int height,int width,int time,int scale,int numAgents) throws InterruptedException{
		Landscape l=new Landscape(width,height);
		LandscapeDisplay Land=new LandscapeDisplay(l,scale);
		//Create a Random object
		Random gen=new Random();
		gen.setSeed(System.currentTimeMillis());
		//this will populate the landscape
		int i=0;
		while(i<=numAgents){
			Grouper a =new Grouper(gen.nextDouble()*height,gen.nextDouble()*width);
			l.addAgent(a);
			
			i++;
		}
		
		
		//Run the actual simulation
		int x=0;
		while(x<=time){
			
			l.updateAgents();
			Land.repaint();
			Thread.sleep(250);
			
			
			x++;
		}
	}
	
public static void main(String[] args) throws InterruptedException{
	GrouperSimulation gs=new GrouperSimulation();
	gs.run(200, 200, 100, 5,2000);
	
}
}
