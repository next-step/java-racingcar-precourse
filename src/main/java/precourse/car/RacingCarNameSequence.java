package precourse.car;

import precourse.race.CarRaceMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarNameSequence {

	public static final String CAR_NAME_DELIMITER = ",";
	public static final int MIN_CAR_NUMBER = 2;
	private final List<String> carNames;

	public RacingCarNameSequence(String carNameSequence) {
		String[] carNames = carNameSequence.split(CAR_NAME_DELIMITER);
		validateCarNumber(carNames);
		validateDuplication(carNames);
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

	private void validateDuplication(String[] carNames) {
		Set<String> carNameSet = new HashSet<>();
		for (String carName : carNames) {
			carNameSet.add(carName.trim());
		}

		if (carNames.length != carNameSet.size()) {
			throw new IllegalArgumentException();
		}
	}

}
