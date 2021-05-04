package racingcar;

import sun.security.validator.ValidatorException;

public class Car implements Comparable<Car> {
	public static final String INVALID_CAR_NAME_MESSAGE = "자동차 이름은 5자 이하만 가능합니다!";
	private final String name;
	private CarDistance distance;

	public Car(String name) throws ValidatorException {
		if (ValidationUtils.isInvalidCarName(name)) {
			throw new ValidatorException(INVALID_CAR_NAME_MESSAGE);
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
