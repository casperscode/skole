package craps;

import java.util.Scanner;

public class CrapsApp {
	
	static boolean cont = true;
	//public static String answer = "";
	//static Scanner scan = new Scanner(System.in);
	
    public static void main(String[] args) {
    	CrapsGame game = new CrapsGame();
        System.out.println("Welcome to the game of Craps.");
        
        game.printRules();
        game.play();
        	
        System.out.println("Thank you for playing craps.");
    }
}
