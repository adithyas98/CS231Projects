/**
 * Project Name:Montecarlo BlackJack Simulation 
 * author Adithya Shastry
 *Class:CS231
 * 2017/09/11
 * This class will handle the cards that the player and the dealer will get while playing the game
 */
 
 //import ARRAYLIST
 import java.util.ArrayList;
 
 
 
public class Hand{
	//This will initialize the hand
	private ArrayList<Card> hand=new ArrayList<Card>();
	public Hand(){
		
		this.hand.clear();
	
	}
	
	public void reset(){
		//This method will reset the hand to empty
		hand.clear();
	}
	public void add(Card card){
		
		//This will add the drawn card to the hand
		hand.add(card);
	}
	public int size(){
		//This will return the size of the hand
		return hand.size();
	}
	public Card getCard(int i){
		//this method will return a Card object when run
		return hand.get(i);
	}
	public int getTotalValue(){
		int total=0;
		for(int i=0;i<hand.size();i++){
			//I will use the getCard() method to return the card and get the actual value of the card
			total=total+this.getCard(i).getValue();
			//Then it will add it to the total value of the hand
		}
		return total;
	}
	public String toString(){
		//In order to print all of the contents of the hand in one line, the strings must be concatenated
		String output="";
		//A for loop will be used to get each individual value in order to concatuate them
		for(int i=0;i<hand.size();i++){
			//This loop will go through each value and 
			output=hand.get(i).getValue()+",";
		}
		return output;
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
