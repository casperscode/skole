package craps;

import java.util.Scanner;

public class CrapsGame {

	DiceThrower thrower = new DiceThrower();
	Scanner scanner = new Scanner(System.in);
	public boolean first = true;
	public boolean finished = false;
	public int goal;
	public String answer;
	
    public void play() {
    	
    	while (!finished) {
    		
    		if(first == true) {
    			thrower.roll();
    			goal = thrower.sum();
    			
    			if(thrower.sum() == 7 || thrower.sum() == 11) {
	    			printGameWon();
	    			System.out.println("");
	    			System.out.println("Play again? y/n");
    				answer = scanner.nextLine();
    				
    				if(answer.equals("y")) {
    					goal = 0;
    					first = true;
    					play();
    				}else
    					break;
    				
        		}	
	    		if (thrower.sum() == 2 || thrower.sum() == 3 || thrower.sum() == 12) {
	    			printGameLost();
	    			System.out.println("");
	    			goal = 0;
	    			first = true;
	    			System.out.println("Play again? y/n");
    				answer = scanner.nextLine();
    				
    				if(answer.equals("y")) {
    					goal = 0;
    					first = true;
    					play();
    				}else
    					break;
    				
	    		}
	    		first = false;
    		}
    		
       		if(first == false) {
       			thrower.roll();
    			if(thrower.sum() == goal) {
    				printGameWon();
    				System.out.println("");
    				System.out.println("Play again? y/n");
    				answer = scanner.nextLine();
    				
    				if(answer.equals("y")) {
    					goal = 0;
    					first = true;
    					play();
    				}else
    					break;
    				
    				
    			}else if (thrower.sum() == 7) {
    				printGameLost();
    				System.out.println("");
    				System.out.println("Play again? y/n");
    				answer = scanner.nextLine();
    				
    				if(answer.equals("y")) {
    					goal = 0;
    					first = true;
    					play();
    				}else
    					break;				
    			}
    		}
    	}   		   		
    		
    	}

    
    /**
     * Prints a 'You have won' message.
     */
    public void printGameWon() {
        System.out.println("\nWinner winner chicken dinner..");
    }

    /**
     * Prints a 'You have lost' message.
     */
    public void printGameLost() {
        System.out.println("\nLOOSER! go home to your mamma..");
    }

    /**
     * Prints the rules of craps.
     */
    public void printRules() {
       System.out.println("In the game a player throws 2 dice. The first throw is called 'the come out roll'.\nThe player wins, if the sum of the dice is 7 or 11.\nThe player loses, if the sum is 2, 3 or 12.\nIf the sum is something else (that is, 4, 5, 6, 8, 9 or 10),\nthe sum is set as the player's 'point'. The player will now continue throwing the dice until he has lost or won.\nA sum equal his 'point' is a win, and a sum equal 7 is a loss.");
    }
    
    
}
