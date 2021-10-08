package racinggame.model;

import java.util.Objects;

public class Distance {

	private static final String CHECK_POSITIVE_ERROR_MESSAGE = "이동거리는 음수가 될수 없습니다.";
	private static final int ZERO_POINT = 0;

	private final int distance;

	public Distance(int distance) {
		checkPositive(distance);
		this.distance = distance;
	}

	private void checkPositive(int distance) {
		if (distance < ZERO_POINT) {
			throw new IllegalArgumentException(CHECK_POSITIVE_ERROR_MESSAGE);
		}
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
