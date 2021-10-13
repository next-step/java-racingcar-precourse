package racinggame.domain;

import java.util.Objects;

public class Distance {

	private static final int DEFAULT_DISTANCE_VALUE = 0;

	private int distance;

	public Distance() {
		this.distance = DEFAULT_DISTANCE_VALUE;
	}

	public int getDistance() {
		return distance;
	}

	public void move() {
		this.distance++;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Distance distance1 = (Distance)o;
		return distance == distance1.distance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(distance);
	}
}
