package racinggame;

public class Distance {
	private String distance = "";

	Distance() {
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
