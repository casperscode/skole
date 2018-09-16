package Ex5;

import java.util.Scanner;

public class Excercise5_04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int in1, in2, in3;
		
		System.out.println("Input 3 values: ");
		in1 = scan.nextInt();
		in2 = scan.nextInt();
		in3 = scan.nextInt();
		
		if (in1 == in2 && in2 == in3) {
			System.out.println("All the same");
		}else {
			System.out.println("All different");
		}
		
		scan.close();
	}

}
