package precourse.utility;

import precourse.race.CarRaceMessage;

public class MovementNumber {

	public static final int MIN_MOVABLE_NUMBER = 4;
	public static final int MIN_NUMBER = 0;
	public static final int MAX_NUMBER = 9;
	private final int number;

	public MovementNumber(int number) {
		validateNumber(number);
		this.number = number;
	}

	public boolean isMovableNumber() {
		return number >= MIN_MOVABLE_NUMBER;
	}

	private void validateNumber(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException(CarRaceMessage.INVALID_MOVEMENT_NUMBER);
		}
	}

}
