
public class CarStack {
	/*
	 * Parking Cars CS231 Adithya Shastry Project 3
	 * 
	 * 
	 * This stack will hold Car objects in it and will act accordingly.The code
	 * for the various methods of a Stack were pasted from the code in the lab
	 * 
	 */
	Car[] stack;
	int top;

	public CarStack(int spots) {
		// This is the constructor class that will create the stack
		this.stack = new Car[spots];
		// The Project guidelines specify that the
		// CarStack Objects can only hold a certain
		// number of cars
		// Top must be equal to zero because there are no values in the stack
		// yet
		this.top = 0;

	}

	public void push(Car new_car) {
		try {// this will try to see if there is space in the array
			stack[this.top] = new_car;
			this.top++;
			// adding 1 to top so that it is updated
		} catch (java.lang.IndexOutOfBoundsException e) {
			// This will catch an index out of bounds exception
			Car[] stack1 = new Car[this.stack.length * 2];
			// This will make the
			// new stack,stack1,
			// two times the
			// size of the
			// original
			// Now to add the new item
			stack1[this.top] = new_car;
			// make stack1 equal to the original stack
			this.stack = stack1;
			this.top++;
		}

	}

	public Car pop() {
		try {
			Car c1 = this.stack[this.top - 1];
			this.stack[this.top - 1] = null;
			// This will remove the item from
			// the stack

			// Data is deleted here because there is nothing being kept here

			this.top--;
			// We want to subtract one from top since we removed an
			// item
			return c1;
			// Will return the top item in the stack. I need to
			// subtract one because

			// c1 is deleted here after it is returned

		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("The Stack is empty!");
			// This error message will
			// print if the stack is
			// empty

			return null;
			// This is so Java doesn't freak out when nothing is
			// being returned
		}

	}

	public Car elementAt(int index) {
		return this.stack[index];
		// returns an element

	}

	public int size() {
		return this.top - 1;
		// The stack might be much larger than the total
		// number of things inside the stack!

	}

	public boolean isEmpty() {
		if (this.top == 0) {
			return true;
		} else {
			return true;
		}

	}

	public Car peak() {
		// This method will peak at the top of the stack and return the object
		// without deleting it from the list
		return this.stack[this.top - 1];
		// We have to subtract one since the
		// value of top is pointing to the next
		// empty spot

	}

	public boolean isFull() {
		// This will check to see if the stack is full
		return this.top >= this.stack.length;
		// If this.top is greater than or
		// equal to the length it will
		// return true.Top should really
		// be equal to the size
		// Since the numSpots variable
		// starts at 1 instead of 0

	}

	public int getTop() {
		return this.top;
	}

	public static void main(String[] args) {
		CarStack s1 = new CarStack(2);
		Car c3 = new Car(23);
		Car c4 = new Car(22);
		s1.push(c3);
		s1.push(c4);
		System.out.println(s1.stack);// Check to see if the push method works

		System.out.println(s1.pop());// Will return the top of the list
		System.out.println(s1.pop());// Will return the top of the list
		System.out.println(s1.pop());// Should return an error
		System.out.println(s1.isEmpty());// Should print true

	}
}
