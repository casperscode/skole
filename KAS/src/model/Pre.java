package model;

public class Pre {
	
	public static void require(boolean precondition) {
		if (!precondition)
			throw new RuntimeException("Suck a chode!");
	}

}