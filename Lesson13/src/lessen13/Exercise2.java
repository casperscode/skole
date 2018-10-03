package lessen13;

public class Exercise2 {

	public static void main(String[] args) {
		double[] ar = {4.1,6.2,7,2,3};
		System.out.println(sum(ar));
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

}
