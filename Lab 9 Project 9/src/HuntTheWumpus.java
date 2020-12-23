import java.util.Random;

import javax.swing.JFrame;

public class HuntTheWumpus {
	Hunter hunter;

	public HuntTheWumpus(int gameSize){
		 

	 this.hunter=new Hunter(new Vertex(0, 0, 0));
	 
		 Landscape land=new Landscape(gameSize,gameSize, 0.8,this.hunter);
		//Randomly generate a place for the hunter and the Wumpus
		Random gen=new Random();
		int hunterIdx=0;
		int wumpusIdx=0;
		do{
			//While the hunter and wumpus are in the same location
			hunterIdx=gen.nextInt(land.getGraph().maxId());
			wumpusIdx=gen.nextInt(land.getGraph().maxId());
			
		}
		while(hunterIdx==wumpusIdx || land.getGraph().getVertex(hunterIdx)==null ||  
				land.getGraph().getVertex(wumpusIdx)==null ||
				land.getGraph().getVertex(hunterIdx).getNeighbors().size()<=0 ||
				land.getGraph().getVertex(wumpusIdx).getNeighbors().size()<=0);
		 this.hunter.setVertex(land.getGraph().getVertex(hunterIdx));
		 Wumpus wumpus=new Wumpus(land.getGraph().getVertex(wumpusIdx));
		 this.hunter.setWumpus(wumpus);
		 
		 
		 //Run Dijkstra's algorithm
		land.getGraph().computePathLengths(wumpusIdx);//This will compute the path lengths from the wumpus
		
	 
	 LandscapeDisplay display=new LandscapeDisplay(land,70,hunter);
	 display.update();
	 
	 
	 //Need to add a controller to make decisions in the game with the action listener
	 //initialize a variable that will hold the game state
	 boolean game=true;//the game is running
	while(game){
		
		//make all the decisions based on if the hunter has arrows and if the wumpus is dead
		if(this.hunter.getArrow()<=0){
			//If the hunter has lost all of his arrows
			
			if(!(this.hunter.getWumpus().getAlive())){
				//if the wumpus is dead
				System.out.println("You have slain the Wumpus!");
				this.hunter.getWumpus().setVisible(true);
				game=false;
				land.graph.makeAllVisible();
				
			}
			else{
				System.out.println("The Wumpus had a nice Lunch!");
				this.hunter.getWumpus().setVisible(true);
				
				game=false;
				land.graph.makeAllVisible();
			}
		}
		else if(!(this.hunter.getWumpus().getAlive())){
			//if the wumpus is dead
			System.out.println("You have slain the Wumpus!");
			this.hunter.getWumpus().setVisible(true);
			game=false;
			land.graph.makeAllVisible();
		}
		else if(this.hunter.getPos()==this.hunter.getWumpus().getPos()){
			//if the hunter walks into the room with the wumpus
			System.out.println("The Wumpus had a nice Lunch!");
			this.hunter.getWumpus().setVisible(true);
			
			land.graph.makeAllVisible();
			game=false;
		}
		
		
		
		display.update();
		
	//	this.hunter.move();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 
	 
	 
	 //Post game interface with either a game over screen or a win screen
		
	}

	public static void main(String[] args) {

		new HuntTheWumpus(6);

	}

	public void addKeyListener(JFrame frame) {
		frame.addKeyListener(hunter);
	}
}
