//Adithya Shastry
//CS231
//2017-09-18
//Spatial Simulation:Game of Life
import java.util.Random;
public class Lifesimulation {
	public static void main(String[] args) throws InterruptedException{
	 Landscape scape = new Landscape(100,100);
        Random gen = new Random();
        double density = 0.3;
        double vdensity=0.301;
        for (int i = 0; i < scape.getRows(); i++) {
            for (int j = 0; j < scape.getCols(); j++ ) { 
        		double randy=gen.nextDouble();
            	if(randy >= density && randy<=vdensity){
            		//this will give a probability of 0.1
            		//and will set the cell equal to a virus
            		scape.getCell(i,j).setVirus(true);
            	
            	}
            	else if(gen.nextDouble() <= density){
                	scape.getCell( i, j ).setAlive(true);//The original code
                }
                else{
                	//if none of the conditions are met then it will run the code 
                
                	scape.getCell(i,j).setAlive(false);
                
                }
            }
        }

        LandscapeDisplay display = new LandscapeDisplay(scape, 4);

        display.repaint();
        
        int i=0;
        
        while(i<=1000){
        	
        
        	scape.advance();
        	display.repaint();
        	i=i+1;
        	Thread.sleep(250);
        	display.saveImage( "data/life_frame_" + String.format( "%03d", i ) + ".png" );
        
		}
	
	
	}
	
	
}
