package precourse.car;

import java.util.Arrays;
import java.util.List;

import precourse.race.CarRaceMessage;

public class RacingCarNameString {

	public static final String CAR_NAME_DELIMITER = ",";
	public static final int MIN_CAR_NUMBER = 2;
	public static final int MIN_LENGTH = 1;
	public static final int MAX_LENGTH = 5;
	private final List<String> carNames;

	public RacingCarNameString(String carNameString) {
		String[] carNames = carNameString.split(CAR_NAME_DELIMITER);
		validateCarNumber(carNames);
		validateCarName(carNames);
		this.carNames = Arrays.asList(carNames);
	}

	public List<String> getCarNames() {
		return carNames;
	}

	private void validateCarNumber(String[] carNames) {
		if (carNames.length < MIN_CAR_NUMBER) {
			throw new IllegalArgumentException(CarRaceMessage.INVALID_CAR_NUMBER);
		}
	}

	private void validateCarName(String[] carNameArray) {
		for (String carName : carNameArray) {
			validateCarNameLength(carName.trim());
		}
	}

	private void validateCarNameLength(String carName) {
		int carNameLength = carName.length();
		if (carName.length() < MIN_LENGTH || carNameLength > MAX_LENGTH) {
			throw new IllegalArgumentException(CarRaceMessage.INVALID_CAR_NAME_LENGTH);
		}
	}

}
