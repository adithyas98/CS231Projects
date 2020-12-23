import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

//This is the helper class for the Graph data structure

public class Vertex extends Agent {
	HashTable<DIRECTION,Vertex> neighbors;
	//The count variable will give the shortest distance from a certain node
	private int count;
	private boolean marked;//This will help keep track of vertices that have already been visited
	private int Id;
	private boolean visible;
	private int x;
	private int y;
	
	
	
	//This is the constructor of the vertex class
	
	public Vertex(int i,int x,int y){
		super(x,y);
		this.neighbors=new HashTable<DIRECTION,Vertex>(4,new DIRECTIONComparator());
		this.setId(i);//this will set the id of the node so that it is easier to track
		this.x=x;
		this.y=y;
		this.visible=false;
		
	}
	
	//Connection method
	public void connect(DIRECTION d, Vertex v){
		this.neighbors.put(d,v);//This will put the value of the vertex and associate it with the correct direction
	}
	//Opposite method
	public DIRECTION Opposite(DIRECTION d){
		if(DIRECTION.NORTH==d){
			return DIRECTION.SOUTH;
		}
		else if(DIRECTION.SOUTH==d){
			return DIRECTION.NORTH;
			
		}
		else if(DIRECTION.WEST==d){
			return DIRECTION.EAST;
		}
		else {
			return DIRECTION.WEST;
		}
		
	}
	
	//GetNeightbor
	public Vertex getNeighbor(DIRECTION d){
		return this.neighbors.get(d);//This will retrieve the vertex being pointed to in the map
	}

	
	//GetNeighbors
	public ArrayList<Vertex> getNeighbors(){
		return this.neighbors.getValues();
	}
	
	
	
	public int compareTo(Vertex arg0) {
		//What needs to go in here?
		return 0;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void updateState(Landscape scape) {
		// TODO Auto-generated method stub
		;
	}

	public void draw(Graphics g, int x0, int y0, int scale) {
			if (!this.visible || this==null) return;
			
			int xpos = x0 + this.x*scale;
			int ypos = y0 + this.y*scale;
			int border = 2;
			int half = scale / 2;
			int eighth = scale / 8;
			int sixteenth = scale / 16;
			
			// draw rectangle for the walls of the cave
			if (this.count <= 2)
				// wumpus is nearby
				g.setColor(Color.red);
			else
				// wumpus is not nearby
				g.setColor(Color.black);
				
			g.drawRect(xpos + border, ypos + border, scale - 2*border, scale - 2 * border);
			
			// draw doorways as boxes
			g.setColor(Color.black);
			if (this.neighbors.containsKey(DIRECTION.NORTH))
				g.fillRect(xpos + half - sixteenth, ypos, eighth, eighth + sixteenth);
			if (this.neighbors.containsKey(DIRECTION.SOUTH))
				g.fillRect(xpos + half - sixteenth, ypos + scale - (eighth + sixteenth), 
					  eighth, eighth + sixteenth);
			if (this.neighbors.containsKey(DIRECTION.WEST))
				g.fillRect(xpos, ypos + half - sixteenth, eighth + sixteenth, eighth);
			if (this.neighbors.containsKey(DIRECTION.EAST))
				g.fillRect(xpos + scale - (eighth + sixteenth), ypos + half - sixteenth, 
					  eighth + sixteenth, eighth);
		}
		
	public void setVisible(boolean b){
		this.visible=b;
	}

	@Override
	public int getCategory() {
		//This should never be used
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
}
class DIRECTIONComparator implements Comparator<DIRECTION>
{
    public int compare(DIRECTION o1, DIRECTION o2)
    {
        return o1.compareTo(o2); 
    }
}
class VertexComparator implements Comparator<Vertex>
{

	@Override
	public int compare(Vertex arg0, Vertex arg1) {
		return arg0.getCount()-arg1.getCount();
		
		
		//This will return a negative number if the vertex on the right is smaller
		//Positive if the vertex on right is bigger
		//zero if they are equal
	}
}

