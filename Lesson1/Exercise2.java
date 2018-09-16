
public class Exercise2 {

	public static int sum()
		{
			int sumtmp = 0;
			
			for (int i = 1; i <= 10; i++)
				sumtmp += i;
		
			return sumtmp;
		}
		
	public static void main(String[] args) {
		
		System.out.println(sum());

	}

}
