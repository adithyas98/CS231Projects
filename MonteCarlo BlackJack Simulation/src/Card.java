/**
 * Project Name:Montecarlo BlackJack Simulation 
 * author Adithya Shastry
 *Class:CS231
 * 2017/09/11
 */
public class Card {
	
	//Setting up variables that can be used to store the value of the card
	private int value;

	public Card(){
		this.value=2;
	}
	public Card(int value){
		//It is important to check that the value of the card is actually valid
		//Try and catch is not valid here because there will not be an actual error in the code,hopefully.
		//This if statement is stipulating that the value inputed in the arguement section must be greater than 0, but less than or equal to 10
		if(value<=10 && value>0){
		//This will assign the value
		this.value=value;
		}
		else{
		//This is an error statement that is printed if the card is out of bounds
		System.out.println("This value does not exist in the game of black Jack");
		}
	}
	public void setValue(int value){
		//It is important to check that the value of the card is actually valid
		//Try and catch is not valid here because there will not be an actual error in the code,hopefully.
		//This if statement is stipulating that the value inputed in the arguement section must be greater than 0, but less than or equal to 11 
		//the value is changed to 11 here to allow for the ace rule!
		if(value<=11 && value>0){
		//This will assign the value
		this.value=value;
		}
		else{
		//This is an error statement that is printed if the card is out of bounds
		System.out.println("This value does not exist in the game of black Jack");
		}
	
	}
	public int getValue(){
		return this.value;
	}
	
	public static void main(String[] args){
		
		Card c1=new Card(5);
		System.out.println(c1.getValue());
		//Here we will check if range checker above works
		Card c2=new Card(15);
		//This should throw an error, since 15>10
		
		
		//Now I will test to see if negative numbers are accepted
		Card c3=new Card(-15);
		//Again this should report an error since -15 is less than 0
	}
}
