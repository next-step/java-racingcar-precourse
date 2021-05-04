package precourse.race;

public class CarRaceAttemptNumber {

	public static final int MIN_ATTEMPT_NUMBER = 1;
	private final int attemptNumber;

	public CarRaceAttemptNumber(String attemptNumber) {
		this.attemptNumber = validateAttemptNumber(attemptNumber);
	}

	public int getNumber() {
		return attemptNumber;
	}

	private int validateAttemptNumber(String attemptNumber) {
		int number = validateAttemptNumberIsNumeric(attemptNumber);
		return validateAttemptNumberRange(number);
	}

	private int validateAttemptNumberRange(int number) {
		if (number < MIN_ATTEMPT_NUMBER) {
			throw new IllegalArgumentException(CarRaceMessage.INVALID_ATTEMPT_NUMBER);
		}
		return number;
	}

	private int validateAttemptNumberIsNumeric(String attemptNumber) {
		try {
			return Integer.parseInt(attemptNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(CarRaceMessage.INVALID_ATTEMPT_NUMBER);
		}
	}

}
