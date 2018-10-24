package lesson15;

import java.util.Arrays;
import java.util.Random;

public class Exercise2 {

	static int Deltager = 8;
	static int Questions = 10;
	
	public static void main(String[] args) {
		char testArray[][] = new char[Deltager][Questions];
		char answers1[] = {'A','A','C','D','B','C','D','B','C','B'};
		int CA[] = new int[Questions];
		
		for(int i = 0; i < Deltager; i++) {
			for(int u = 0; u < Questions; u++) {
				testArray[i][u] = randomSeriesForCharacter();
				
				if(testArray[i][u] == answers1[u]) {
					CA[i] += 1;
				}								
			}
		}
		
		
		for(int i = 0; i < Deltager; i++) {
			System.out.println("Deltager "+(i+1)+": "+Arrays.toString(testArray[i])+" Correct answers : "+CA[i]);
		}
	}
	
	public static char randomSeriesForCharacter() {
	    Random r = new Random();
	    char random_3_Char = (char) (65 + r.nextInt(4));
	    return random_3_Char;
	}

}
