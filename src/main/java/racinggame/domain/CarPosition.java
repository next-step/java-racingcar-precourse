package racinggame.domain;

import racinggame.message.ErrorMessage;

public class CarPosition {
	private static int INCREASE_UNIT = 1;

	private int carPosition;

	public CarPosition(int carPosition) {
		this.carPosition = carPosition;
	}

	public int getCarPosition() {
		return this.carPosition;
	}

	public void increase(int random) {
		validateDistance(random);
		if (random > 3) {
			this.carPosition += INCREASE_UNIT;
		}
	}

	private void validateDistance(int distance) {
		if (distance < 0 || distance > 9) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_DISTANCE.name());
		}
	}
}
