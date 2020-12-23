/*
 * Adithya Shastry
 * CS231 Fall 2017
 * Finding people Project 4
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class LinkedList<T> implements Iterable<T> {
	//The <T> is a generic that will allow me to use this class for any type of object or primitive data type
	
	//Initialize the necessary variables
	private Node<T> head;//This is the first item in the list
	private int counter=0;//This will count the number of items in the list
	public int getCounter() {
		return counter;
	}
	public LinkedList(){
		//this will return an empty list
		this.head=null;//This will set the head node to null making reference to all other nodes go away
	}
	public void clear(){
		this.head=null;
		//This will make all the elements in the list lose their references. WE can't just make this.head.next equal to null because that would not erase the value of this.head
		this.counter=0;//This is because the list has been cleared
	}
	public int size(){
		return this.counter;//This will return the size of the list
	}
	public void addFirst(T item){
		//First we will make the new node and set its next value to where the header is pointing
		Node<T> n=new Node<T>(item,this.head);
		//Now we need to point the head to the value of the new node
		this.head=n;
		this.counter++;
	}
	public void addLast(T item){
		//There are two possible situations:one for when the list is empty and one for when it has more than one item
		if(this.head==null){
			//If the head value isn't pointing to anything
			//We will call the add to first method
			this.addFirst(item);
		}
		else{
			//If the are items in the list
			Node<T> ptr= this.head;
			while(ptr.getNext() != null){
				ptr=ptr.getNext();
			}
			Node<T> n=new Node<T>(item,null);
			//this will set the new node equal to the pointer's next field
			ptr.setNext(n);//this will set the pointer to point to the new node
			this.counter++;
		}
		
	}
	public void add(T item,int index){
		//there are 3 possible situations for the index number: at the end or beyond the end, in the middle, and at the beginning
		//These will be handled differently 
		//The basis for the logic here will be how the index compares to the counter variable
		if(index<=1){
			//This means that the value will be added to the head of the list
			//I will just call the already written function
			this.addFirst(item);
		}
		else if(index>=this.counter){
			//The value of the index is greater than or equal to the value of the counter, then the value will be added to the end of the list
			
			this.addLast(item);
		}
		else{
			//The only other possible situation is to have the index be in the middle of the node
			Node<T> ptr=this.head;
			int i=0;//i will be used to count the position in the list
			while(i<index){
				//this means that it will go to the index and add the node to the one after it
				ptr=ptr.getNext();
				i++;
			}
			//Now the pointer will point to the preferred position in the list
			
			//We need to make the node point to the next field of the pointer node
			//create a node
			Node<T> n=new Node<T>(item,ptr.getNext());
			//this will set the new node equal to the pointer's next field
			ptr.setNext(n);//this will set the pointer to point to the new node
			counter++;
		}
		
	}
	public void remove(int index){
		//I will iterate to the node right before the index we want to remove
		Node<T> ptr=this.head;
		int i=0;
		while(i<index-1){
			//We want to subtract one because we want the one before it
			ptr=ptr.getNext();
			i++;
		}
		//Now we need to make the pointer point to the next value of the next node
		ptr.setNext(ptr.next.next);
		//Now the node at the index will be garbage collected because nothing will be pointing to it
		
		this.counter--;
		
	}
	
	public ArrayList<T> toArrayList(){
		ArrayList<T> output =new ArrayList<T>();
		for(T item : this){
			output.add(item);
		}
		return output;
	}
	public ArrayList<T> toShuffledList(){
		ArrayList<T> output=this.toArrayList();//I need to create an array list first before I can shuffle it therefore i will call a method I have already created
		ArrayList<T> newOutput= new ArrayList<T>();//This will serve as the new list that has been shuffled.
		Random gen=new Random();
		for(int i=0;i<output.size();i++){
			//This will iterate through the entire list of objects
			newOutput.add(output.remove(gen.nextInt(output.size())));//We don't want indices that are outside of the range because we don't want a out of bounds exception
		}
		return newOutput;
	}
	
	// Return a new LLIterator pointing to the head of the list
	public Iterator<T> iterator() {
			return new LLIterator( this.head );
	}
	
	
	//This will create a node class that will be used to hold the values of the node
	private class Node<T>{
		T data;
		Node<T> next;
		public Node(T item,Node<T> n){//This is the constructor for the class
			this.next=n;
			this.data=item;
		}
		public T getThing(){//Will return the data held by the node
			return this.data;
		}
		public void setNext(Node<T> n){
			this.next=n;//Will set the next node to n
		}
		public Node<T> getNext(){
			if(!(this==null)){
				return this.next;
			}
			else{
				return null;
			}
		}
		
		
		
	}
	private class LLIterator implements Iterator<T>{
		private Node<T> ptr;
		public LLIterator(Node<T> head){
			ptr=head;
		}
		public boolean hasNext(){
//			return this.ptr.getNext()!=null;
			if (ptr == null){
				return false;
			}
			return true;
			
		}
		public T next(){
			T d= ptr.getThing();
			ptr=ptr.getNext();
			//this will return the next value
			return d;//There seems to be an error here for some reason
		}
	}
	

public static void main(String[] args) {
		
		LinkedList<Integer> llist = new LinkedList<Integer>();
		
		llist.addFirst(5);
		llist.addFirst(10);
		llist.addFirst(20);
	
		System.out.printf("\nAfter setup %d\n", llist.size());
		for(Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}
	
		llist.clear();
	
		System.out.printf("\nAfter clearing %d\n", llist.size());
		for (Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}
		
		llist.addLast(5);
		llist.addLast(10);
		llist.addLast(20);
	
		System.out.printf("\nAfter setup %d\n", llist.size());
		for(Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}
	
		llist.clear();
	
		System.out.printf("\nAfter clearing %d\n", llist.size());
		for (Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}
	
		for (int i = 10; i > 0; i -= 2) {
			System.out.println("before: "+llist.counter);
			llist.add(0, i);
			System.out.println("after: "+llist.counter);
		}
		
		for (Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}
		
		llist.add(5, 12);
		llist.add(3, 0);

		System.out.printf("\nAfter setting %d\n", llist.size());
		for (Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}

		llist.remove(0);
		System.out.printf("\nAfter removing %d\n", llist.size());
		for (Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}
		
		llist.remove(2);
		System.out.printf("\nAfter removing %d\n", llist.size());
		for (Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}
		
		llist.remove(4);
		System.out.printf("\nAfter removing %d\n", llist.size());
		for (Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}
	
		ArrayList<Integer> alist = llist.toArrayList();
		System.out.printf("\nAfter copying %d\n", alist.size());
		for(Integer item: alist) {
			System.out.printf("thing %d\n", item);
		}						
		
		alist = llist.toShuffledList();	
		System.out.printf("\nAfter copying %d\n", alist.size());
		for(Integer item: alist) {
			System.out.printf("thing %d\n", item);
		}





}
}
