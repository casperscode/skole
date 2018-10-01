package pigs;

public class Player {
	
	private String pName;
	private int totalPoints;
	

	public String getpName() {
		return pName;
	}
	
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
