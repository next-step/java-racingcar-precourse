package racinggame.domain;

import nextstep.utils.Randoms;

public class Car {
	private final String name;

	private final Distance distance;

	public Car(String name) {
		this.name = name;
		this.distance = new Distance();
	}

	public void drive() {
		accelerate();
	}

	private void accelerate() {
		int number = Randoms.pickNumberInRange(0, 9);

		if (number > 3) {
			distance.add();
		}
	}

	public String getName() {
		return name;
	}

	public Distance getDistance() {
		return distance;
	}
}
