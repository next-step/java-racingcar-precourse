package precourse.car;

import precourse.race.CarRaceMessage;

public class RacingCarName {

	public static final int MIN_LENGTH = 1;
	public static final int MAX_LENGTH = 5;
	private final String carName;

	public RacingCarName(String carName) {
		String trimmedCarName = carName.trim();
		validateCarNameLength(trimmedCarName);
		this.carName = trimmedCarName;
	}

	public String getValue() {
		return carName;
	}

	private void validateCarNameLength(String carName) {
		int carNameLength = carName.length();
		if (carNameLength < MIN_LENGTH || carNameLength > MAX_LENGTH) {
			throw new IllegalArgumentException(CarRaceMessage.INVALID_CAR_NAME_LENGTH);
		}
	}

}
