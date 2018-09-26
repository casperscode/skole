package simple;

public class DiceThrower {
	// 2 dice with face count of 6 each
	private Die die1, die2;

	//private Die die1 = new Die(6);
	//private Die die2 = new Die(6);
	
	private int rollCount;
	private int rollSum;
	private int count6;
	private int doubleRoll;
	private double avgRoll;
	private int hRoll;
	
	// TODO: Add fields.
	// Fields:
	// 1. The roll count.
	// 2. The total of all face values rolled.
	// 3. The count of face value 6.
	// 4. The count of same face value on both dice.
	// 5. The maximum sum of the face values in one roll.
	// Remember to update fields, when the dice are rolled.

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
	// TODO: Make a constructor that initialises all fields.

	// TODO: Add get methods for the fields.

	/*
	 * Rolls the 2 dice.
	 */
	
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

	/**
	 * Returns the sum of the face values in a roll.
	 */
	
	public int sum() {		
		return die1.getFaceValue()+die2.getFaceValue();
	}

	/**
	 * Returns a textual description of the roll of the 2 dice.
	 * Example: Returns "(4,5)" for a roll of 4 and 5.
	 */
	public String rollDescription() {
		// TODO: Use the method: String.format().
		return "";
	}
}
