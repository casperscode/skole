package aggregation_group01_0mperson;

public class Pre {
	public static void require(boolean precondition) {
		if (!precondition)
			throw new RuntimeException("Pre condition violated");
	}
}
