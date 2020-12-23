/**
 * Project Name:Montecarlo BlackJack Simulation 
 * author Adithya Shastry
 *Class:CS231
 * 2017/09/11
 */
 //This will import the ArrayList class that is used below
import java.util.ArrayList;
//This will import the Random class used in the Shuffle Method
import java.util.Random;







//This will create a Deck class that can be used to create deck instances
public class Deck {
	//Creating an ArrayList in order to store the cards in the deck
	//Card is an object that is passed through that will allow the program to hold Card objects
	private ArrayList<Card> al= new ArrayList<Card>();
	public Deck(){
		this.build();
		this.shuffle();
	}
	
	
	
	public void build(){
		for(int i=1;i<10;i++){
			//This will add 4 of the same card to the deck
			
			
			
			for (int x=1;x<5;x++){
				//This will create a new Card object called c that will hold the card value
				//This class can be found in the Class.java file
				Card c =new Card(i);
				//This will add the value to the ArrayList al. In other words build the card deck
				al.add(c);
				
				
				
			}
			//This will add 16 cards with values of 10
		}
		
		
		
		for (int x=1;x<=16;x++){
			//Creating a card object
			Card c =new Card(10);
			//This will add the value to the ArrayList al. In other words build the card deck
			al.add(c);
			/**
			This part of the function will create a Card object called c that will point to the space where the value of the card
			is held. Once the for loop runs again, it will have to stop using c as the pointer to the data and instead will use
			the specific index in the ArrayList as its reference point. Every opperation after this, other than the accessor method
			in the Card class, will use the same process.
			*/
	}
	}
	//This method will implement the Shuffle feature of the deck
	public void shuffle(){
	
	
		Random randy =new Random();
		//This will generate a random seed that can be used by the random number generator
		long seed=System.currentTimeMillis();
		randy.setSeed(seed);
		//Card objects must be created since the data being held in these variables are card objects
		Card a;
		//this new arraylist will be used to hold the values of the shuffled deck
		ArrayList<Card> shuffled=new ArrayList<Card>();
			
			for(int i=0;i<52;i=i+1){
				int r1;
				r1=randy.nextInt(52);
				a=al.get(r1);
				shuffled.add(a);
			}
			//This will make it so that al is equal to the shuffled deck
			al=shuffled;
	}		
			
			
			
	public String toString(){
		//This is the output variable
		String output="";
		//This will print the value of the string to the console
		for(int i=0; i<al.size();i++){
			//We need to add the .getValue method since the objects in this ArrayList are Card objects that
			//have a specific accessor method in order to get the data necessary 
			//This will add together strings
				output=output+(al.get(i).getValue()+"," );
			
		}
		return output;
	}
	public Card deal(){
		//this will return the card object from the deck to desired location
		return this.al.remove(0);
	}
	public int size(){
		return al.size();

}
	public static void main(String[] args){
		Deck d3=new Deck();
		d3.shuffle();
		System.out.println(d3.toString());
		System.out.println(d3.deal().getValue());
		System.out.println(d3.toString());
	
	
	
	
	
	
	
	}
}