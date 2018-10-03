package lesson13;

import java.util.Arrays;

public class Exercise1 {

	public static void main(String[] args) {
		int[] arrayA = new int[10];
		int[] arrayB = {2,44,-23,99,8,-5,7,10,20,30};
		int[] arrayC = new int[10];
		for(int i = 0; i < 10; i++) {
			arrayC[i] = i;
		}
		
		int[] arrayD = new int[10];
		for(int i = 0; i < 10; i++) {
			arrayD[i] = i*2;
		}
		
		int[] arrayE = new int[10];
		for(int i = 0; i < 10; i++) {
			arrayE[i] = i+1+(i*i+i);
		}
		
		int[] arrayF = new int[10];
		for(int i = 0; i < 10; i++) {
			if(i % 2 == 0) {
				arrayF[i] = 0;
			}else {
				arrayF[i] = 1;
			}
		}
		
		int[] arrayG = new int[10];
		for(int i = 0; i < 10; i++) {
			if(i <= 4 ) {
				arrayG[i] = i;
			}else {
				arrayG[i] = i-5;
			}
		}
		
		int[] arrayH = new int[10];
		for(int i = 0; i < 10; i++) {
			arrayH[i] = i-(i*i);
		}
		
		System.out.println(Arrays.toString(arrayA));
		System.out.println(Arrays.toString(arrayB));
		System.out.println(Arrays.toString(arrayC));
		System.out.println(Arrays.toString(arrayD));
		System.out.println(Arrays.toString(arrayE));
		System.out.println(Arrays.toString(arrayF));
		System.out.println(Arrays.toString(arrayG));
		System.out.println(Arrays.toString(arrayH));
	}

}
