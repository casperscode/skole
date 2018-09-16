package Ex5;

import java.util.Scanner;

public class Excercise5_02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float in;
		
		System.out.println("Input an Integer value: ");
		in = scan.nextFloat();
		
		if (in == 0)
			System.out.println("Value is 0");
		
		if (in > 0) {
			if (in < 1 && in > -1)
				System.out.println("Value is small");
			
			if (in > 1000000)
				System.out.println("Value is large");
			
			System.out.println("Value is positive");
		}
		
		if (in < 0) {
			if (in < 1 && in > -1)
				System.out.println("Value is small");
		
			System.out.println("Value is negative");
		}
		
		scan.close();
	}

}
