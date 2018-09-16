package printer;

import java.util.Random;
import java.util.Scanner;

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
		
		if(paperStuck == true) {
			System.out.println("Error, paper is stuck in the copy machine");
		}
		
		if(paperCount == 0) {
			System.out.println("Error, no paper in the copy machine");
		}
		
		System.out.println("Printing page..");
		paperCount--;
	}
	
	public void makeCopy(int copies) {
		
		//Random number for jam
		Random rand = new Random();
		int  n = rand.nextInt(6) + 1;	
		if (n == 4)
			makePaperJam();
		
		int u = 1;
		
		if(paperStuck == true) {
			System.out.println("Error, paper is stuck in the copy machine. Fix this? [Y/N]");
			Scanner scan = new Scanner(System.in);
			String answer = "";
			answer = scan.next();
			if(answer == "y")
				fixPaperJam();
			else if( answer != "y") {
				System.out.println("Error, paper is stuck in the copy machine. Fix this? [Y/N]");
				answer = scan.next();
			}
			scan.close();
		}
		
		if(paperCount == 0) {
			System.out.println("Error, no paper in the copy machine");
		}
		
		for (int i = copies; i > 0; i--) {
			System.out.printf("\nPrinting page %d of %d", u, copies);
			paperCount--;
			u++;
			
			if(paperStuck == true) {
				System.out.println("Error, paper is stuck in the copy machine");
			}
		}
		System.out.println("\n" + n);
		System.out.println("\n");
	}

	public void makePaperJam() {
		paperStuck = true;
	}
	
	public void fixPaperJam() {
		paperStuck = false;
	}
}
