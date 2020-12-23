import java.util.Scanner;

//This class will allow the user to control the environment through inputs in the command line
public class Controller {
	public void gameType(int h,int w,int t, int num) throws InterruptedException{
		System.out.println("Please indicate what game you would like to simulate:(1)Catogrized grouper or (2) Grouper");
		Scanner reader=new Scanner(System.in);
		int game=reader.nextInt();
		if(game==1){
			CategorizedGrouperSimulation gs=new CategorizedGrouperSimulation();
			gs.run(h, w, t, 1,num);
		}
		else if(game==2){
			GrouperSimulation gs=new GrouperSimulation();
			gs.run(h, w, t, 1,num);
		}
		else{
			System.out.println("That wasn't a valid imput!");
			this.gameType(h, w, t, num);
		}
	}
	public static void main(String[] args) throws InterruptedException{
		Controller c=new Controller();
		Scanner reader=new Scanner(System.in);
		int height;
		int width;
		int time;
		int numAgents;
		System.out.println("Please input the Height:\n");
		height=reader.nextInt();
		System.out.println("Please input the Width:\n");
		width=reader.nextInt();
		System.out.println("Please input the Time:\n");
		time=reader.nextInt();
		System.out.println("Please input the Number of Agents:\n");
		numAgents=reader.nextInt();
		
		c.gameType(height, width, time, numAgents);
	}
}
