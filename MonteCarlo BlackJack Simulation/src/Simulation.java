/**
 * Project Name:Montecarlo BlackJack Simulation 
 * author Adithya Shastry
 *Class:CS231
 * 2017/09/11
 * This class will handle the cards that the player and the dealer will get while playing the game
 */
 
 
 //This will initialize the simulation class for the project
 //the main purpose of the class is to run a game 1000 times and output the results
 public class Simulation{

  
  
  public static void main(String[] args){
  		//These variables will be used to count and calculate the statistics
 		int playerwin=0;
 		int dealerwin=0;
		int push=0;
 		int totalgames=0;
 		
 		
		Blackjack game= new Blackjack();
		int win;
		double averagepwin;
		for( int l=0;l<16;l++){
		
		
		for(int i=0;i<=1000;i++){
			win=game.play();
			totalgames=i;
			if(win==1){
				playerwin=playerwin+1;
			
			
			}
			else if (win==2){
				
				dealerwin=dealerwin+1;
				
			}
			else{
				push=push+1;
			
			
			}
			
		}
		System.out.println("Here are the Statistics:");
		System.out.println("The player won: "+playerwin+"! ");
  		System.out.println("The Dealer won: "+dealerwin+"! ");
  		System.out.println("There were "+push+" number of pushes!");
  		System.out.println(totalgames+" games were played!");
		
		} 
		averagepwin=(((double)playerwin)/((double)15));
		System.out.println("This is the player's average number of wins: "+averagepwin+" per 1000 games");
	
  }
  
  
 
 
 
 
 
 
 
 
 }