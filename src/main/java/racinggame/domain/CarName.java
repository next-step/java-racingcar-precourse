package racinggame.domain;

import static racinggame.common.Message.*;

import racinggame.exception.OutOfBoundCarNameLengthException;

public class CarName {

	private static final int MAX_LENGTH = 5;
	private static final int MIN_LENGTH = 1;

	private String carName;

	public CarName(String name) {
		if (!checkCarNameLength(name)) {
			throw new OutOfBoundCarNameLengthException(CAR_NAME_LENGTH_ERROR.getMessage());
		}
		this.carName = name;
	}

	private boolean checkCarNameLength(String name) {
		int nameLength = name.length();
		return nameLength <= MAX_LENGTH && nameLength >= MIN_LENGTH;
	}

	public String getCarName() {
		return this.carName;
	}
}
