import java.awt.Graphics;
import java.util.Random;

//this class will be used to create and maintain the landscape and update vertices when necessary

public class Landscape {
	Vertex[][] land;
	Graph graph;// this is the layout of the game

	int width;
	int length;

	Hunter hunter;

	// The constructor should create a hunter character, create the landscape,
	// and finally add the vertices into the graph

	public Landscape(int width, int length, double density, Hunter h) {
		this.hunter = h;
		this.width = width;
		this.length = length;
		// create a graph
		this.graph = new Graph(width * length);
		// Create the correct landscape
		this.land = new Vertex[width][length];
		int count = 0;// this will be used to set the id numbers
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				Random randy = new Random();
				if (randy.nextDouble() <= density) {
					// Now add the vertices to the list and the graph
					Vertex v = new Vertex(count, i, j);

					graph.add(v);// This will add the vertex to the graph
					land[i][j] = v;// this will add the same vertex to the 2d
									// array
				} else {
					// add a null pointer
					graph.add(null);
					land[i][j] = null;
				}
				// Iterate the count
				count++;

			}
		}

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				// Now we need to make the correct connections
				try {
					graph.connect(land[i][j].getId(), land[i + 1][j].getId(), DIRECTION.EAST);// East
				} catch (Exception e) {
					;
				}
				try {
					graph.connect(land[i][j].getId(), land[i - 1][j].getId(), DIRECTION.WEST);// West
				} catch (Exception e) {
					;
				}
				try {
					graph.connect(land[i][j].getId(), land[i][j + 1].getId(), DIRECTION.SOUTH);// south
				} catch (Exception e) {
					;
				}
				try {
					graph.connect(land[i][j].getId(), land[i][j - 1].getId(), DIRECTION.NORTH);// North
				} catch (Exception e) {
					;
				}

				// Any null pointers will be dealt in the actual connect method
				// at the Graph level
			}
		}

	}

	public void draw(Graphics g, int gridScale) {
		// Will draw the landscape
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				try {
					land[i][j].draw(g, 0, 0, gridScale);
				} catch (Exception e) {
					;
				}
			}
		}
		this.hunter.draw(g, gridScale);
		this.hunter.getWumpus().draw(g, gridScale);
	}

	public int getlength() {
		return this.length;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	public Graph getGraph() {
		return this.graph;
	}

	// public Vertex moveHunter(Vertex v,DIRECTION d){
	// //will allow the hunter to move and assign it a vertex
	//
	// //this will take in a vertex and the direction the player wants to move
	// in.
	//
	// }

}
