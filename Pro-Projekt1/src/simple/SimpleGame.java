package simple;

import java.util.Scanner;

public class SimpleGame {

    /*
     * Simulates playing one game of Simple.
     */
	
    public void play() {
        Scanner scanner = new Scanner(System.in);
        DiceThrower thrower = new DiceThrower();

        boolean finished = false;
        while (!finished) {
            thrower.roll();
           
            System.out.println("Roll again? (Y/n) ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                finished = true;
            }
        }
        scanner.close();

        System.out.printf("\nResults:\n");
        System.out.printf("Highest roll: %d \nDouble rolls: %d \nSix'es Rolled: %d \nRoll Average: %.2f \nTotal Sum: %d \n", thrower.gethRoll(), thrower.getDoubleRoll(), thrower.getCount6(), thrower.getavgRoll(), thrower.getRollSum() );
        System.out.printf("---------\n");
        
        // TODO: Print all the results:
        // roll count, total of all face values, average sum in one roll,
        // count of face value 6, count of same face value on both dice,
        // max sum in one roll.
        // Use the method: System.out.printf().

    }

    /*
     * Prints the rules of Simple.
     */
    
    public void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Simple:");
        System.out.println("The player throws the 2 dice as long as he/she wants.");
        System.out.println("=====================================================");
    }

}
