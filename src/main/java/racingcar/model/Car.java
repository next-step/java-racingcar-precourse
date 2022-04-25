package racingcar.model;

public class Car {
	public static final int BOUNDARY_VALUE = 4;
	public static final int DISTANCE = 1;
	public static final int MAX_LENGTH = 6;

	private final String carName;
	private int distance;

	public Car(String carName) {
		validateName(carName);
		this.carName = carName;
		this.distance = 0;
	}

	private void validateName(String carName) {
		if (carName == null || carName.isEmpty()) {
			throw new IllegalArgumentException(Message.EMPTY_NAME);
		}
		if (carName.length() >= MAX_LENGTH) {
			throw new IllegalArgumentException(Message.LONG_CAR_NAME);
		}
	}

	public void advance(int randomNumber) {
		if (randomNumber >= BOUNDARY_VALUE) {
			this.distance += DISTANCE;
		}
	}

	public int getDistance() {
		return this.distance;
	}

	public String getCarName() {
		return this.carName;
	}
}
