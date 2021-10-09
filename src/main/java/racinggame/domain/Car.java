package racinggame.domain;

import nextstep.utils.Randoms;

public class Car {
	private static final int MOVABLE_MIN_NUMBER = 4;
	private static final int RANDOM_MIN_VALUE = 0;
	private static final int RANDOM_MAX_VALUE = 9;
	private final Name name;
	private final Distance distance;

	public Car(Name name) {
		this.name = name;
		distance = Distance.of(0);
	}

	public void move() {
		if (isMovable()) {
			distance.increase();
		}
	}

	private boolean isMovable() {
		return Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE) >= MOVABLE_MIN_NUMBER;
	}

	public Distance getDistance() {
		return distance;
	}

	public Name getName() {
		return name;
	}
}
