package racinggame.domain;

public class Distance {
	private String distance = "";

	Distance() {
	}

	public int value() {
		return distance.length();
	}

	public void distance(int random) {
		if (random >= 4) {
			distance += "-";
		}
	}

	@Override
	public String toString() {
		return distance;
	}
}
