package racinggame.service;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.Car;
import racinggame.domain.CarName;
import racinggame.domain.Cars;
import racinggame.message.ErrorMessage;

public class RacinggameService {
	private static final String CAR_NAME_INPUT_REGEX = ",";

	public Cars createCars(String carNameInput) {
		validateCarNameInput(carNameInput);
		String[] carNames = carNameInput.split(CAR_NAME_INPUT_REGEX);
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < carNames.length; i++) {
			carList.add(new Car(new CarName(carNames[i])));
		}
		return new Cars(carList);
	}

	private void validateCarNameInput(String carNameInput) {
		if (carNameInput.equals("") || carNameInput.contains(" ")) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_INPUT.name());
		}
	}

	public void validateMoveCountInput(String moveCountInput) {
		try {
			if (Integer.parseInt(moveCountInput) < 1) {
				throw new IllegalArgumentException(ErrorMessage.INVALID_MOVE_COUNT_INPUT.name());
			}
		} catch (NumberFormatException e) {
			throw new NumberFormatException(ErrorMessage.INVALID_MOVE_COUNT_INPUT.name());
		}
	}
}
