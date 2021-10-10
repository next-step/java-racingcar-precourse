package racinggame.domain;

import racinggame.message.ErrorMessage;

public class CarPosition {
	private int carPosition;

	public CarPosition(int carPosition) {
		this.carPosition = carPosition;
	}

	public int getCarPosition() {
		return this.carPosition;
	}

	public void increase(int distance) {
		validateDistance(distance);
		if (distance > 3) {
			this.carPosition += distance;
		}
	}

	private void validateDistance(int distance) {
		if (distance < 0 || distance > 9) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_DISTANCE.name());
		}
	}
}
