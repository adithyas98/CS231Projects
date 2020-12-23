import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Hunter extends Agent implements KeyListener {
	private Vertex pos;// This will hold the information to the vertex the
						// hunter is in
	private int arrows;// holds the number of arrows
	private DIRECTION d;// This will hold the direction the hunter is trying to
						// go
	private Wumpus wumpus;
	private boolean shoot = false;

	public Hunter(Vertex v) {
		super(v.getX(), v.getY());
		// TODO Auto-generated constructor stub
		// v.setVisible(true);
		this.arrows = 2;
	}

	@Override
	public void updateState(Landscape scape) {
		// TODO Auto-generated method stub

	}

	public void draw(Graphics g, int scale) {
		// Need to figure out how to actually draw the hunter
		g.setColor(Color.GREEN);
		g.fillOval(this.pos.getX() * scale + scale / 4, this.pos.getY() * scale + scale / 4, scale / 2, scale / 2);
	}

	@Override
	public int getCategory() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setVertex(Vertex v) {
		this.pos = v;// Set the correct when the player moves
		v.setVisible(true);
	}

	public int reduceArrow() {
		// this will reduce the number of arrows by one
		return this.arrows--;
	}

	public int addArrow() {
		return this.arrows++;
	}

	public int getArrow() {
		// will return the count of the arrow;
		return this.arrows;
	}

	public void move() {
		// shooting the arrow should be implemented here

		if (shoot && this.arrows > 0 && !(this.d==null)) {
			// If the player pressed the space bar
			if (this.pos.getNeighbor(this.d) == this.wumpus.getPos()) {
				// If the positions of the wumpus is the same as the direction
				// the player is shooting the arrow
				this.wumpus.setAlive(false);

				this.reduceArrow();
				// Set the shoot variable to false

			} else {
				this.reduceArrow();// reduce the arrow
				System.out.println("Missed :(");
			}
			this.shoot = false;
			return;

		}

		// This will take the vertex that the hunter is trying to move to
		if (d != null && this.pos.getNeighbor(d) != null) {
			this.pos = this.pos.getNeighbor(this.d);
			this.setX0(this.pos.getX0());
			this.setY0(this.pos.getY0());
			this.pos.setVisible(true);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == (KeyEvent.VK_W)) {
			d = DIRECTION.NORTH;
		} else if (arg0.getKeyCode() == (KeyEvent.VK_S)) {
			d = DIRECTION.SOUTH;
		} else if (arg0.getKeyCode() == (KeyEvent.VK_A)) {
			d = DIRECTION.WEST;
		} else if (arg0.getKeyCode() == (KeyEvent.VK_D)) {
			d = DIRECTION.EAST;
		} else if (arg0.getKeyCode() == (KeyEvent.VK_SPACE)) {
			if (this.shoot) {
				this.shoot = false;
			} else {

				this.shoot = true;
			}
		}
		this.move();
		d = null;

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == (KeyEvent.VK_W) && this.d == DIRECTION.NORTH)
			d = null;
		else if (arg0.getKeyCode() == (KeyEvent.VK_S) && this.d == DIRECTION.SOUTH)
			d = null;
		else if (arg0.getKeyCode() == (KeyEvent.VK_A) && this.d == DIRECTION.EAST)
			d = null;
		else if (arg0.getKeyCode() == (KeyEvent.VK_D) && this.d == DIRECTION.WEST)
			d = null;
		else if (arg0.getKeyCode() == (KeyEvent.VK_SPACE))
			;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	public void setWumpus(Wumpus w) {
		this.wumpus = w;
	}

	public Wumpus getWumpus() {
		// Will return the wumpus
		return this.wumpus;
	}

	public Vertex getPos() {
		// TODO Auto-generated method stub
		return this.pos;
	}
}
