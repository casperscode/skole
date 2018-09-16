package Ex5;

import java.util.Scanner;

public class Excercise5_03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int in, inTmp;		
		int count = 0;
		
		System.out.println("Input an Integer value: ");
		in = scan.nextInt();
		inTmp = in;
		
		if (in < 0) {
			in = in*(-1);
		}
		
		while(inTmp != 0) {
			inTmp /= 10;
			count++;
		}
		System.out.println(in + " The value is " + count + " digits long");
		
		scan.close();
	}

}
