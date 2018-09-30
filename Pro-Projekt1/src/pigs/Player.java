package pigs;

public class Player {
	
	private String pName;
	private String answer;
	
	
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
