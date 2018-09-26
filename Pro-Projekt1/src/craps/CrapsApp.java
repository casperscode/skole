package craps;

public class CrapsApp {
	
	static boolean cont = true;
	//public static String answer = "";
	//static Scanner scan = new Scanner(System.in);
	
    public static void main(String[] args) {
    	CrapsGame game = new CrapsGame();
        System.out.println("Welcome to the game of Craps.");
        System.out.println("----------------------------------------------------------");
        game.printRules();
        System.out.println("----------------------------------------------------------");
        
        System.out.println("");
        game.play();
        	
        System.out.println("Thank you for playing craps.");
    }
}
