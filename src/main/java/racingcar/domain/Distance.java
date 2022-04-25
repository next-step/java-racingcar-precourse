package racingcar.domain;

public class Distance {
	public static final int MIN_DEMAND_VALUE = 4;

	private int distance;

	public Distance() {
		distance = 0;
	}

	public Distance(int distance) {
		this.distance = distance;
	}

	public void move(int number) {
		if(MIN_DEMAND_VALUE <= number) {
			distance += 1;
		}
	}

	public int getDistance() {
		return distance;
	}

	public boolean isLongerThan(int compareDistance) {
		return this.distance > compareDistance;
	}

	public boolean isEqual(int compareDistance) {
		return distance == compareDistance;
	}
}
