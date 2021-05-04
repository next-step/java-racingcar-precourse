package racingcar;

import sun.security.validator.ValidatorException;

public class Car implements Comparable<Car> {
	public static final int MIN_NAME_LENGTH = 1;
	public static final int MAX_NAME_LENGTH = 5;
	public static final int MIN_MOVE_VALUE = 4;
	private final String name;

	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance;
	}

	private int distance = 0;

	public Car(String name) throws ValidatorException {
		this.name = name;
		if (this.isInvalidName()) {
			throw new ValidatorException("Car name invalid!");
		}
	}

	public boolean isInvalidName() {
		return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
	}

	public boolean isMovable(int random) {
		return random >= MIN_MOVE_VALUE;
	}

	public int move(int random) {
		if (isMovable(random)) {
			this.stepForward();
		}
		return distance;
	}

	private void stepForward() {
		this.distance++;
	}

	private String printDistance() {
		StringBuilder stringDistance = new StringBuilder();
		for (int i = 0; i < distance; i++) {
			stringDistance.append("-");
		}
		return stringDistance.toString();
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
		return this.name + " : " + this.printDistance();
	}
}
