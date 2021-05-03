package precourse.car;

import precourse.race.CarRaceMessage;

public class RacingCarName {

	public static final int MIN_LENGTH = 1;
	public static final int MAX_LENGTH = 5;
	private final String carName;

	public RacingCarName(String carName) {
		String trimmedCarName = carName.trim();
		validateCarName(trimmedCarName);
		this.carName = trimmedCarName;
	}

	public String getName() {
		return carName;
	}

	private void validateCarName(String carName) {
		if (carName.length() < MIN_LENGTH || carName.length() > MAX_LENGTH) {
			throw new IllegalArgumentException(CarRaceMessage.INVALID_CAR_NAME_LENGTH);
		}
	}

}
