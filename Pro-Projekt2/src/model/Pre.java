package model;

public class Pre {
	
	public static void require(boolean condition) {
		if(!condition) {
			throw new RuntimeException("Pre violated");
		}
	}
}
