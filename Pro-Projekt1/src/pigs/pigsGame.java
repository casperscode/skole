package pigs;

import java.util.Scanner;

public class pigsGame {

	private Player p1, p2;
	private Die die;
	public int turnThrow = 0;
	public boolean finished = false;
	public boolean token = true;
	public String GV;
	public String answer = "y";
	public String cont = "";
	Scanner scan = new Scanner(System.in);
	Scanner scan2 = new Scanner(System.in);
	public int gameScore;
	
	public pigsGame() {
		System.out.println("Do you want to play the to something else than 100 points? y/n");
		
		if (scan.nextLine().equalsIgnoreCase("y")) {
			System.out.println("Enter the amount of points required to win");
			gameScore = scan.nextInt();
		}else {
			gameScore = 100;
		}
		
		scan.nextLine();
		System.out.println("Enter player one's name: ");
		String p1name = scan.nextLine();
		System.out.println("Enter player two's name: ");
		String p2name = scan.nextLine();
		p1 = new Player(p1name);
		p2 = new Player(p2name);
		die = new Die();
	}
	
	public void run() {
		
		while(!finished) {
			
			if(token) {
				
				die.roll();
						
				if(die.getFaceValue() == 1) {
					p1.updateTotal(0);
					turnThrow = 0;
					token = false;
					System.out.println("You rolled a 1 and loose your yurn. Press enter to continue..");
					cont = scan2.nextLine();
					run();
					}else {
						turnThrow += die.getFaceValue(); 
				}
				
				if(turnThrow >= gameScore)
					p1.updateTotal(turnThrow);
					
				System.out.println("Player "+p1.getpName() +" rolled: "+die.getFaceValue()+". You have "+turnThrow+" points so far");
				System.out.println("The score is [ "+p1.getpName()+" : "+p1.getTotalPoints()+" ] [ "+p2.getpName()+" : "+p2.getTotalPoints()+" ]");
				System.out.println("Roll again? [y/n]");
				
				if(p1.getTotalPoints() >= gameScore || (turnThrow+p1.getTotalPoints() >= gameScore)) {
					System.out.println(p1.getpName()+" you won the game");
					finished = true;
					gameOver();
				}
					
				answer = scan2.nextLine();
					
				if(answer.equalsIgnoreCase("n")) {
					token = false;
					p1.updateTotal(turnThrow);
					turnThrow = 0;
				}
			}
								
			if(!token) {
				
				die.roll();
						
				if(die.getFaceValue() == 1) {
					p2.updateTotal(0);
					turnThrow = 0;
					token = true;
					System.out.println("You rolled a 1 and loose your yurn. Press enter to continue..");
					cont = scan2.nextLine();
					run();
				}else {
					turnThrow += die.getFaceValue();
				}
				
				if(turnThrow >= gameScore)
					p2.updateTotal(turnThrow);
				
				System.out.println("Player "+p2.getpName() +" rolled: "+die.getFaceValue()+". You have "+turnThrow+" points so far");
				System.out.println("The score is [ "+p1.getpName()+" : "+p1.getTotalPoints()+" ] [ "+p2.getpName()+" : "+p2.getTotalPoints()+" ]");
				System.out.println("Roll again? [y/n]");
				
				if(p2.getTotalPoints() >= gameScore || turnThrow+p2.getTotalPoints() >= gameScore) {
					System.out.println(p2.getpName()+" You won the game with "+p2.getTotalPoints());
					finished = true;
					gameOver();
				}
				
				answer = scan2.nextLine();
					
				if(answer.equalsIgnoreCase("n")) {
					token = true;
					p2.updateTotal(turnThrow);
					turnThrow = 0;
				}
			}						
		}	
		scan2.close();
		scan.close();
	}

	public void gameOver() {
		System.out.println("The game has ended..");
	}
}
