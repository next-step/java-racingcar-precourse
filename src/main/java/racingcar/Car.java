package racingcar;

import sun.security.validator.ValidatorException;

public class Car {
	public static final int MIN_NAME_LENGTH = 1;
	public static final int MAX_NAME_LENGTH = 5;
	public static final int MIN_MOVE_VALUE = 4;
	private String name;
	private int distance = 0;

	public Car(String name) throws ValidatorException {
		this.name = name;
		if(this.isInvalidName()) {
			throw new ValidatorException("Car name invalid!");
		}
	}

	public boolean isInvalidName() {
		return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
	}

	public boolean isMove(int random) {
		return random >= MIN_MOVE_VALUE;
	}

	public int move(int random) {
		if(isMove(random)) {
			this.stepForward();
		}
		return distance;
	}

	private void stepForward() {
		this.distance++;
	}
}
