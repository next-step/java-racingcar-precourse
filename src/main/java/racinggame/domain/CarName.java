package racinggame.domain;

import static racinggame.common.Message.*;

import racinggame.exception.OutOfCarNameLengthException;

public class CarName {

	private static final int MAX_LENGTH = 5;

	private String carName;

	public CarName(String carName) {
		if (carName.length() > MAX_LENGTH) {
			throw new OutOfCarNameLengthException(CAR_NAME_LENGTH_ERROR.getMessage());
		}
		this.carName = carName;
	}

	public String getCarName(){
		return this.carName;
	}
}
