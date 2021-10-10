package racinggame.domain;

import racinggame.message.ErrorMessage;

public class CarName {
	private final String carName;

	public CarName(String carName) {
		validateCarName(carName);
		this.carName = carName;
	}

	private void validateCarName(String carName) {
		if (carName == null) {
			throw new NullPointerException(ErrorMessage.INVALID_CAR_NAME.name());
		}

		if (carName.length() < 1 || carName.length() > 5) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.name());
		}
	}

	public String getCarName() {
		return this.carName;
	}
}
