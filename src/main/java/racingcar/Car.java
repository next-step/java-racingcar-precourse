package racingcar;

import sun.security.validator.ValidatorException;

public class Car implements Comparable<Car> {
	private final String name;
	private CarDistance distance;

	public Car(String name) throws ValidatorException {
		if (RacingRule.isInvalidCarName(name)) {
			throw new ValidatorException("Car name invalid!");
		}
		this.name = name;
		this.distance = new CarDistance();
	}

	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance.getDistance();
	}

	public int move(int random) {
		if (RacingRule.isMovable(random)) {
			this.stepForward();
		}
		return getDistance();
	}

	private void stepForward() {
		distance.increase();
	}

	@Override
	public int compareTo(Car car) {
		if (this.getDistance() < car.getDistance()) {
			return 1;
		} else if (this.getDistance() > car.getDistance()) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return this.name + " : " + distance;
	}
}
