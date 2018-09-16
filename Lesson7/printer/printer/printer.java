package printer;

import java.util.Random;


public class printer {
	
	private int paperCount;
	
	boolean paperStuck = false;
	
	public void Printer() {
		paperCount = 0;
	}
	public void Printer(int paperCount) {
		paperCount = this.paperCount;
	}
	
	public void insertPaper(int amount) {
		if (amount > 500) {
			System.out.println("Printer cannot fit this much paper, reseed with less than 500 pages");
			paperCount = 0;
		}
		paperCount = amount;
	}
	
	public int getPaperCount() {
		return paperCount;
	}
	
	public void makeCopy() {
		Random rand = new Random();
		int  n = rand.nextInt(6) + 1;	
		
		if (n == 4)
			makePaperJam();
				
		if(paperCount == 0) {
			System.out.println("Error, no paper in the copy machine");
		}
		
		System.out.println("Printing page..");
		paperCount--;
	}
	
	public void makeCopy(int copies) {		
		int u = 1;
		
		if(paperCount == 0) {
			System.out.println("Error, no paper in the copy machine");
		}
		
		for (int i = copies; i > 0; i--) {
			//Random number for jam
			Random rand = new Random();
			int  n = rand.nextInt(6) + 1;	
			
			if (n == 4)
				makePaperJam();
			
			System.out.printf("\nPrinting page %d of %d\n", u, copies);
			paperCount--;
			u++;
		}
		
		System.out.println("\n");
	}

	public void makePaperJam() {
		paperStuck = true;
		System.out.println("A paper is jamming in the printer");
		fixPaperJam();
	}
	
	public void fixPaperJam() {
		paperStuck = false;
		System.out.println("Printer jam now fixed");
	}
}
