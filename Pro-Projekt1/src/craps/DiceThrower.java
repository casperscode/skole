package craps;

import simple.Die;

public class DiceThrower {
	
	private Die die1, die2;
	
	private int rollCount;
	private int rollSum;
	private int count6;
	private int doubleRoll;
	private double avgRoll;
	private int hRoll;

	/*
	 * Creates a TwoDice object.
	 */
	public DiceThrower() {
		die1 = new Die(6);
		die2 = new Die(6);
		
		rollCount = 0;
		rollSum = 0;
		count6 = 0;
		doubleRoll = 0;
		hRoll = 0;
	}

	public void roll() {
		die1.roll();
		die2.roll();
		rollCount++;
		
		if(die1.getFaceValue() == die2.getFaceValue()) 
			doubleRoll++;
		
		if(die1.getFaceValue() == 6 || die2.getFaceValue() == 6) {
			if(die1.getFaceValue() == 6 && die2.getFaceValue() == 6) {
				count6 += 2;
			}else {
				count6++;
			}
		}
		
		if(sum() > hRoll)
			hRoll = sum();
		
		
		rollSum += sum();
		
		System.out.println("Player rolled: "+die1.getFaceValue()+" & "+die2.getFaceValue());
	}

	public Die getDie1() {
		return die1;
	}

	public Die getDie2() {
		return die2;
	}

	public int getRollCount() {
		return rollCount;
	}

	public int getRollSum() {
		return rollSum;
	}

	public int getCount6() {
		return count6;
	}

	public int getDoubleRoll() {
		return doubleRoll;
	}

	public int gethRoll() {
		return hRoll;
	}
	
	public double getavgRoll() {		
		avgRoll = (double)rollSum/(double)rollCount;
		return avgRoll;
	}
	
	public int sum() {		
		return die1.getFaceValue()+die2.getFaceValue();
	}


	public String rollDescription() {
		// TODO: Use the method: String.format().
		return "";
	}
}
