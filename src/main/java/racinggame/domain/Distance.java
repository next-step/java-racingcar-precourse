package racinggame.domain;

public class Distance {
	static final int COMPARE_NUMBER = 4;
	private String distance = "";

	Distance() {
	}

	public int value() {
		return distance.length();
	}

	public void distance(int random) {
		if (random >= COMPARE_NUMBER) {
			distance += "-";
		}
	}

	@Override
	public String toString() {
		return distance;
	}
}
