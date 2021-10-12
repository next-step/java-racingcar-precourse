package racinggame.domain;

import static racinggame.common.Message.*;

import racinggame.exception.OutOfBoundCarNameLengthException;

public class CarName {

	private static final int MAX_LENGTH = 5;
	private static final int MIN_LENGTH = 1;

	private String carName;

	public CarName(String carName) {
		if (!checkCarNameLength()) {
			throw new OutOfBoundCarNameLengthException(CAR_NAME_LENGTH_ERROR.getMessage());
		}
		this.carName = carName;
	}

	private boolean checkCarNameLength() {
		int nameLength = carName.length();
		return nameLength <= MAX_LENGTH && nameLength >= MIN_LENGTH;
	}

	public String getCarName() {
		return this.carName;
	}
}
