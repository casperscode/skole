package pigs;

public class Player {
	
	private String pName;
	private String answer;
	private double AvgThrow;
	private double Throw;
	private double ThrowCount;
	
	public void setThrow(double count) {
		Throw = count;
	}
	
	public double getThrow() {
		return Throw;
	}
	
	public double getThrowCount() {
		return ThrowCount;
	}
	
	public void setAvgThrow() {
		AvgThrow += (Throw/2);
	}
	
	public double getAvgThrow() {
		
		return 0;
	}
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getpName() {
		return pName;
	}

	private int totalPoints;
	
	public int getTotalPoints() {
		return totalPoints;
	}

	public Player(String name) {
		pName = name;
		totalPoints = 0;
	}
	
	public void updateTotal(int value) {
		totalPoints += value;
	}

}
