package racinggame.domain;

public class Distance {

	private static final int DEFAULT_DISTANCE_VALUE = 0;

	private int distance;

	public Distance() {
		this.distance = DEFAULT_DISTANCE_VALUE;
	}

	public int getDistance() {
		return distance;
	}
}
