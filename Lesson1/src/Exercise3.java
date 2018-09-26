package src;

public class Exercise3 {

	public static int sum()
		{
			int sumtmp = 1;
			
			for (int i = 1; i <= 10; i++)
				sumtmp *= i;
		
			return sumtmp;
		}
		
	public static void main(String[] args) {
		
		System.out.println(sum());

	}

}
