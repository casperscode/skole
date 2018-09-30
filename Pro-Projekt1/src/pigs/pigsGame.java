package pigs;

import java.util.Scanner;

public class pigsGame {

	private Player p1, p2;
	private Die die;
	public boolean finished = false;
	public boolean token = true;
	public String GV;
	public String answer = "y";
	public String cont = "";
	Scanner scan = new Scanner(System.in);
	Scanner scan2 = new Scanner(System.in);
	public int gameScore = 100;
	
	public pigsGame() {
		System.out.println("Do you want to play the to something else than 100 points? y/n");
		GV = scan2.nextLine();
		
		if (GV.equals("y")) {
			System.out.println("Enter the amount of points required to win");
			gameScore = scan2.nextInt();
		}else {
			gameScore = 100;
		}
		
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
					token = false;
					System.out.println("You rolled a 1 and loose your yurn. Press enter to continue..");
					cont = scan.nextLine();
					run();
					}else {
						p1.updateTotal(die.getFaceValue());
				}
					
				System.out.println("Player "+p1.getpName() +" rolled: "+die.getFaceValue());
				System.out.println("The score is [ "+p1.getpName()+" : "+p1.getTotalPoints()+" ] [ "+p2.getpName()+" : "+p2.getTotalPoints()+" ]");
					
				if(p1.getTotalPoints() >= gameScore) {
					System.out.println(p1.getpName()+" you won the game");
					finished = true;
					gameOver();
				}
					
				System.out.println("Roll again? [y/n]");
					
				answer = scan.nextLine();
					
				if(answer.equals("n")) {
					token = false;
				}
			}
								
			if(!token) {
				
				die.roll();
						
				if(die.getFaceValue() == 1) {
					p2.updateTotal(0);
					token = true;
					System.out.println("You rolled a 1 and loose your yurn. Press enter to continue..");
					cont = scan.nextLine();
					run();
				}else {
					p2.updateTotal(die.getFaceValue());
				}
			
				System.out.println("Player "+p2.getpName() +" rolled: "+die.getFaceValue());
				System.out.println("The score is [ "+p1.getpName()+" : "+p1.getTotalPoints()+" ] [ "+p2.getpName()+" : "+p2.getTotalPoints()+" ]");
				System.out.println("Roll again? [y/n]");
				
				if(p2.getTotalPoints() >= gameScore) {
					System.out.println(p2.getpName()+" You won the game");
					finished = true;
					gameOver();
				}
				
				answer = scan.nextLine();
					
				if(answer.equals("n")) {
					token = true;
				}
			}						
		}	
		scan.close();
		scan2.close();
	}

	public void gameOver() {
		System.out.println("The game has ended..");
	}
}
