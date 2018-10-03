package lesson13;

import java.util.Arrays;

public class Exercise4 {

	public static void main(String[] args) {
		int[] iAr1 = {4,6,7,2,3,2,6};
		int[] iAr2 = {1,5,7,3,9,8};
		double[] dAr1 = {4.3,6,7,2,3,2.4,6};
		double[] dAr2 = {4.9,6,7.8,2,3,5.7};
		System.out.println("Array holds even number(s) : "+hasUneven(iAr2));
		System.out.println("Integer array sum : "+Arrays.toString(sumArrays(iAr1,iAr2)));
		System.out.println("Double array sum : "+Arrays.toString(sumArrays(dAr1,dAr2)));
	}
	
	public static int sum(int[] t) {
		int Sum = 0;
		
		for(int i: t)
			Sum += i;
		
		return Sum;
	}
	
	public static double sum(double[] d) {
		double Sum = 0;
		
		for(double i: d)
			Sum += i;
		
		return Sum;
	}
	
	public static int[] sumArrays(int[] a, int[] b) {
		 int[] aSum = new int[(int) Math.max(a.length, b.length)];
	        for (int i = 0; i < aSum.length; i++) {
	            if (a.length > i) {
	            	aSum[i] += a[i];
	            }
	            if (b.length > i) {
	            	aSum[i] += b[i];
	            }
	        }
	        return aSum;
	}
	
	public static double[] sumArrays(double[] a, double[] b) {
		double[] aSum = new double[(int) Math.max(a.length, b.length)];
        for (int i = 0; i < aSum.length; i++) {
            if (a.length > i) {
            	aSum[i] += a[i];
            }
            if (b.length > i) {
            	aSum[i] += b[i];
            }
        }
        return aSum;
	}
	
	public static boolean hasUneven(int[] t) {
		boolean even = false;
		
		for(int i = 0; i < t.length; i++) {
			if(t[i] % 2 == 0)
				even = true;
		}
		
		return even;
	}

}
