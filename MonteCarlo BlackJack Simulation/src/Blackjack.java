/**
 * Project Name:Montecarlo BlackJack Simulation 
 * author Adithya Shastry
 *Class:CS231
 * 2017/09/11
 */

 
public class Blackjack {
//This will create the blackjack class
	Deck d1=new Deck();
	//Create two hands
	Hand player=new Hand();
	Hand dealer=new Hand();
	
	public Blackjack(){
		
		this.reset();
	}
	public void reset(){
		//This will reset the deck if need be
		if(d1.size()<15){
			//12 was decided to be the largest a single hand could possibly be. Three was added for a cushion incase the math was wrong
			//if it is true a new deck will be created
			this.d1.build();
			this.d1.shuffle();
			
			
	}
	}
	public void deal(){
		//This will add the card to the hand
		//Since the cards are usually dealt one at a time to all players, I will alternate between dealer and player
		int i=0;
		while(i<=1){
		player.add(d1.deal());
		dealer.add(d1.deal());
		i=i+1;
		}
		
	}
	public int whoWon(){
	//This will tell us who won
		//If the player wins the integer returned will be 1
		//if the dealer wins the integer returned will be 2
		//If there is a push the integer returned will be 3
		
		
		//This will check if the player went bust
		if(player.getTotalValue()>21){
			return 2;
			//The dealer will win here since the player went bust
		
		}
		else if(dealer.getTotalValue()>21){
			return 1;
			//this is because the player will win if the dealer went bust
		}
		else if (player.getTotalValue()==21){
			return 1;
		
		}
		else if(dealer.getTotalValue()==21){
			return 2;
			}
		else if(player.getTotalValue() !=21 && dealer.getTotalValue()!= 21){
			//None of them went bust or got a black jack
			if(player.getTotalValue() == dealer.getTotalValue()){
					//Both the dealer and the player have the same amount
				return 3;
				//Since this is a push 3 is returned
			}
			else if(player.getTotalValue()>dealer.getTotalValue()){
				//The player wins since the value is higher
				return 1;
			}
			else{
				//The only other option is if the dealer wins
				return 2;
			}
		
		}
		else{
		System.out.println("There was an error");
		return 0;
		
		}
	}

	
	public String toString(int wincheck){
		//This logic block will see what the state of the game is
		if(wincheck==1){
			return "The player Won this round!";
		}
		else if(wincheck==2){
			return"The Dealer Won this round :(";
		}
		else{
			//The only other option is if there was a push
			return"There was a push!";
		}
		
	}
	public void playerTurn(){
	//Will check if there is an ace and execute accordingly
		this.ace(player);
		//This will run a players turn
		//This will be run by a logic block
		if(player.getTotalValue()>13 && player.getTotalValue()<21){
					//The player would stop in this situation
					//therefore it is the dealer's turn
					this.dealerTurn();
		
		}
		else if(player.getTotalValue()>21){
		//The player loses and it will route to the whoWon() method to see whoWon();
			this.whoWon();
		}
		
		
		else {
			//The player is forced to hit
			player.add(d1.deal());
			//This process will continue till the player goes bust or stops
			//Thus the playerTurn() method will be called again
			this.playerTurn();
			}
		}
		
	public void dealerTurn(){
	//Will check if there is an ace and execute accordingly
		this.ace(dealer);
		//This will run a dealer's turn
		//This will be run by a logic block
		if(dealer.getTotalValue()>17 && dealer.getTotalValue()<21){
					//The dealer would stop in this situation
					//This will lead straight to whoWon since the player has already gone
					this.whoWon();
		
		}
		else if(dealer.getTotalValue()>21){
		//The player loses and it returns false
		//This will go straight to whoWon() since the dealer went bust
			this.whoWon();
		}
		else{
		//the only other option is for the dealer to draw
		dealer.add(d1.deal());
		//Now we have to check if the dealer is allowed to draw another card
		this.dealerTurn();
		}
		

	
	}		

	public int play(){
		//This integer will hold the value that will track who has won for statistics
		int winner=0;
		//First we need to create a new deck or check to see if we have to do that
		this.reset();
		//the gameplay will start below
		//first with a deal
		this.deal();
		//The player will go first
		this.playerTurn();
		//Everything else is dependent on what the player does since he goes first
		winner=this.whoWon();
		System.out.println(this.toString(winner));
		player.reset();
		dealer.reset();

		return winner;
		
		//The idea here is to be able to run this game as many times as possible using the simulation class 
	}
	public static void main(String[] args){
		Blackjack game=new Blackjack();
		game.play();
		
	
	
	
	
	}
		public void ace(Hand hand){
		//This will check to see if the ace rule is useful to the player or not and execute based on that
		int value;//This int will old the new total value of the hand to see if it is beneficial to change the value
		for(int i=0;i<hand.size();i++){
			if(hand.getCard(i).getValue()==1){
				value=hand.getTotalValue()+10;
				if(value>hand.getTotalValue() && value<=21){
					//this will make sure the value change will be greater than the initial value of the deck
					//and the that it doesn't make the player go bust
					hand.getCard(i).setValue(11);
				
				
				}
				
			
			}
			else if(hand.getCard(i).getValue()==11 && hand.getTotalValue()>21){
				//This will run if the value is already changed
				hand.getCard(i).setValue(1);
				//this will make sure the player doesn't go bust
			
			
			}
		
		
		}
	
	
	}
}	
	








