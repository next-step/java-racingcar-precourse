package precourse.utility;

import precourse.race.CarRaceMessage;

public class MovementNumber {

	public static final int MINIMUM_MOVABLE_NUMBER = 4;
	public static final int MINIMUM_NUMBER = 0;
	public static final int MAXIMUM_NUMBER = 9;
	private final int number;

	public MovementNumber(int number) {
		validateNumber(number);
		this.number = number;
	}

	private void validateNumber(int number) {
		if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
			throw new IllegalArgumentException(CarRaceMessage.INVALID_MOVEMENT_NUMBER);
		}
	}

	public boolean isMovableNumber() {
		return number >= MINIMUM_MOVABLE_NUMBER;
	}

}
