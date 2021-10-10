package racinggame.domain.boxing;

import java.util.Objects;

import racinggame.common.ConstValue;

import racinggame.error.EmptyCarException;
import racinggame.error.ErrorMessage;

public class CarName {
	private final String carName;

	public CarName(String carName) {
		validateEmptyCar(carName);
		validateCarName(carName);
		this.carName = carName;
	}

	private void validateEmptyCar(String carName) {
		if(Objects.isNull(carName) || carName.isEmpty())
			throw new EmptyCarException();

	}

	private void validateCarName(String carName) {
		if(carName.length() > ConstValue.MAX_NAME_SIZE)
			//throw new CarNameLengthException();
			System.out.println(ErrorMessage.INVALID_CAR_NAME_INPUT);
			//throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_INPUT);

	}

}
