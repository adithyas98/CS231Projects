import java.util.Random;

public class CategorizedGrouperSimulation {

		public void run(int height,int width,int time,int scale,int numAgents) throws InterruptedException{
			Landscape l=new Landscape(width,height);
			LandscapeDisplay Land=new LandscapeDisplay(l,scale);
			//Create a Random object
			Random gen=new Random();
			gen.setSeed(System.currentTimeMillis());
			//this will populate the landscape
			int i=0;
			while(i<=numAgents){
				CategorizedGrouper a =new CategorizedGrouper(gen.nextDouble()*height,gen.nextDouble()*width,1+gen.nextInt(10));
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
		CategorizedGrouperSimulation gs=new CategorizedGrouperSimulation();
		gs.run(200, 200, 100, 5,2000);
		
	}
	}

