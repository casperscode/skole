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
    		first = false;
    		if(thrower.sum() == 7 || thrower.sum() == 11) {
    			printGameWon();
    			finished = true;
    			System.out.println("Play again? [Y/n]");
    			answer = scanner.nextLine();
    			if (answer.equals("n")) {
                    finished = true;
                }
    		}else if (thrower.sum() == 2 || thrower.sum() == 3 || thrower.sum() == 12) {
    			printGameLost();
    			System.out.println("Play again? [Y/n]");
    			answer = scanner.nextLine();
    			if (answer.equals("n")) {
                    finished = true;
                }
    		}else {
    			goal = thrower.sum();
    		}
    	}else {
    		thrower.roll();
    		if(thrower.sum() == goal) {
    			printGameWon();
    			finished = true;
    			System.out.println("Play again? [Y/n]");
    			answer = scanner.nextLine();
    			if (answer.equals("n")) {
                    finished = true;
                }
    		}else if (thrower.sum() == 7) {
    			printGameLost();
    			finished = true;
    			System.out.println("Play again? [Y/n]");
    			answer = scanner.nextLine();
    			if (answer.equals("y")) {
                    finished = true;
                	}
    			
    			}
    	}
    	}
    	}

    
    /**
     * Prints a 'You have won' message.
     */
    public void printGameWon() {
        System.out.println("Winner winner chicken dinner..");
    }

    /**
     * Prints a 'You have lost' message.
     */
    public void printGameLost() {
        System.out.println("LOOSER! go home to your mamma..");
    }

    /**
     * Prints the rules of craps.
     */
    public void printRules() {
       System.out.println("lets do this..");
    }
    
    
}
