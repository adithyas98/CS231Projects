import java.awt.Color;
import java.awt.Graphics;

//this will hold the wumpus character that will be placed in a vertex 
public class Wumpus extends Agent{
	
	private boolean alive;//This will be used to see if the wumpus is still alive. 
	//If this wumpus is dead it will change the value to false and the game will end with the player winning the game
	private Vertex pos;//This will hold the vertex where the Wumpus resides
	private boolean visible;

	public Wumpus(Vertex v) {
		super(v.getX(),v.getY());//We will set this once we have the vertex the wumpus is at
		this.alive=true;
		this.pos=v;
		this.visible=false;
	}

	
	@Override
	public void updateState(Landscape scape) {
		// TODO Auto-generated method stub
		
	}

	public void draw(Graphics g,int scale) {
		//Display a win or loss screen
		if(this.visible){
			
		if(this.alive){
			g.setColor(Color.BLUE);
		}
		else {
			g.setColor(Color.RED);
		}
		g.fillOval(this.pos.getX()*scale+scale/4, this.pos.getY()*scale+scale/4, scale/2, scale/2);
		}
		
		
	}
	public void setVisible(boolean b){
		//will set the visibility

		this.visible=b;
	}

	@Override
	public int getCategory() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public Vertex getPos(){
		return this.pos;
	}


	public void setAlive(boolean b) {
		this.alive=b;
		
	}
	public boolean getAlive(){
		return this.alive;
	}


	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
