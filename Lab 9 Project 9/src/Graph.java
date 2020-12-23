
//This will actually hold the graph and a list of all the vertices in the graph
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Graph {

	private ArrayList<Vertex> vertices;

	public Graph(int numVertices) {
		this.vertices = new ArrayList<Vertex>(numVertices);
		// Adding vertices to the list will be handled in the landscape class
	}

	// public Graph( int[][] adj ) {
	// this.vertices = new ArrayList<Vertex>(adj.length);
	// for (int i = 0; i<adj.length; i++) {
	// this.vertices.add( new Vertex(i) );
	// }
	// for (int i = 0; i < adj.length; i++) {
	// for (int j = 0; j < adj[0].length; j++) {
	// if (adj[i][j] == 1) {
	// this.connect( i, j );
	// }
	// }
	// }
	// }

	// Add edge from from-th vertex to to-th vertex.
	public void connect(int from, int to, DIRECTION d)  {
		try{
			//Just incase there is a null pointer
			
			this.vertices.get(from).connect(d, this.vertices.get(to));
			// this will connect the vertex in the correct direction
		}
		catch(NullPointerException e){
			return;//This will deal with any null pointer exceptions
		}
		
		

	}

	public void dump() {
		for (int i = 0; i < this.vertices.size(); i++) {
			System.out.print(this.vertices.get(i) + ": ");
			for (Vertex v : this.vertices.get(i).getNeighbors()) {
				System.out.print(v + ", ");
			}
			System.out.println("");
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < vertices.size(); i++) {
			int[] nbs = new int[vertices.size()];
			for (Vertex v : vertices.get(i).getNeighbors()) {
				nbs[v.getId()] = 1;
			}
			for (int j = 0; j < vertices.size(); j++) {
				s += nbs[j] + " ";
			}
			s += "\n";
		}
		return s;
	}

	private void unmarkAll() {
		for (Vertex v : this.vertices) {
			v.setMarked(false);
		}
	}

	// Mark each node in a depth first search. When each
	// node is marked, print out the node's id.
	public void depthFirstSearch(int startingFrom) {
		this.unmarkAll();
		Stack<Vertex> stack = new Stack<Vertex>();
		stack.push(this.vertices.get(startingFrom));
		System.out.println("Stack is now: " + stack);
		while (!stack.isEmpty()) {
			Vertex v = stack.pop();
			System.out.println("Stack is now: " + stack);
			if (!v.isMarked()) {
				v.setMarked(true);
				System.out.println("Marking vertex " + v.getId());
				for (Vertex nbr : v.getNeighbors()) {
					stack.push(nbr);
					System.out.println("Stack is now: " + stack);
				}
			}
		}
	}

	// Mark each node in a breadth first search. When each
	// node is marked, print out the node's id.
	public void breadthFirstSearch(int startingFrom) {
		this.unmarkAll();
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		queue.offer(this.vertices.get(startingFrom));
		System.out.println("Queue is now: " + queue);
		while (!queue.isEmpty()) {
			Vertex v = queue.poll();
			System.out.println("Queue is now: " + queue);
			v.setMarked(true);
			System.out.println("Marking vertex " + v.getId());
			for (Vertex nbr : v.getNeighbors()) {
				if (!nbr.isMarked() && !queue.contains(nbr)) {
					queue.offer(nbr);
					System.out.println("Queue is now: " + queue);
				}
			}
		}
	}

	// Run Dijkstra's algorithm to determine the length of the shortest path
	// to each VertexSolution.
	public void computePathLengths(int startingFrom) {

		// Mark the vertices as unmarked and set the cost to infinite

		for (Vertex v : this.vertices) {
			if(v!=null){
			v.setCount(Integer.MAX_VALUE);
			v.setMarked(false);
			}
		}

		// Now I will set the cost of the starting vertex to 0

		Vertex v = this.vertices.get(startingFrom);
		v.setCount(0);

		// create a priority queue
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(new VertexComparator());
		// Add the value of v to the priority queue
		
		pq.offer(v);

		while (pq.peek() != null) {
			// remove the head of the priority queue
			Vertex v0 = pq.poll();
			v0.setMarked(true);
			for (Vertex w : v0.getNeighbors()) {
				if (!w.isMarked() && w.getCount() > v0.getCount() + 1) {
					w.setCount(v0.getCount()+1);
					pq.offer(w);

				}

			}

		}
		// Uncomment this line to get the print statements that match the
		// expected output
		System.out.println("Path from v" + startingFrom + " to v" + v.getId() + " has length " + v.getCount());
	}

	public static void main(String[] args) {
		// test Dijkstra's algorithm here

	}

	public void add(Vertex v) {
		this.vertices.add(v);
	}

	public int maxId() {
		return this.vertices.size();
	}
	public Vertex getVertex(int id){
		return this.vertices.get(id);
		
	}
	
	public void makeAllVisible(){
		for(Vertex v:this.vertices){
			try{
			
			v.setVisible(true);
			}
			catch(NullPointerException e){
				;
			}
		}
	}

}
