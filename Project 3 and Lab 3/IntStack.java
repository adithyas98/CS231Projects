
public class IntStack {

	int[] stack;
	int top;
	public IntStack() {
		//This is the constructor class that will create teh stack
		stack=new int[10];
		//Top must be equal to zero because there are no values in the stack yet
		this.top=0;
		
		
	}
	public void push(int new_item){
		try{//this will try to see if there is space in the array
			stack[this.top]=new_item;
			this.top++;
			//adding 1 to top so that it is updated
		}
		catch(java.lang.IndexOutOfBoundsException e){
			//This will catch an index out of bounds exception
			int[] stack1=new int[this.lenght*2];//This will make the new stack,stack1, two times the size of the original
			//Now to add the new item
			stack1[this.top]=new_item;
			//make stack1 equal to the original stack
			this.stack=stack1;
		}
	
	
	}
	public int pop(){
		try {
		return this.stack[this.top-1]//Will return the top item in the stack. I need to subtract one because 
		this.stack[this.top-1]=null;//This will remove the item from the stack
		this.top--;//We want to subtract one from top since we removed an item
		}
		catch()
	
	
	
	}	
	public int elementAt(int index){
		return this.stack[index];//returns an element
	
	}
	
	public int size(){
		return this.top-1;//The stack might be much larger than the total number of things inside the stack!
	
	
	
	}
	
	public boolean isEmpty(){
		if(this.top==0){
				return true
		}
		else{
			return true;
		}
	
	
	
	}

	
	
	public static void main(String[] args){
		Intstack s1=new Intstack();
		s1.push(15);
		System.out.println(s1.stack);//Check to see if the push method works
		
	
	}
}
