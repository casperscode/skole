package Ex5;

import java.util.Scanner;

public class Excercise5_01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int in;
		
		System.out.println("Input an Integer value: ");
		in = scan.nextInt();
		
		if (in == 0)
			System.out.println("Value is 0");
		
		if (in > 0)
			System.out.println("Value is positive");
		
		if (in < 0)
			System.out.println("Value is negative");
		
		scan.close();
		

	}

}
