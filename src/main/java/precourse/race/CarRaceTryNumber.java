package precourse.race;

public class CarRaceTryNumber {

	public static final int MINIMUM_TRY_NUMBER = 1;
	private final int tryNumber;

	public CarRaceTryNumber(String tryNumber) {
		this.tryNumber = validateTryNumber(tryNumber);
	}

	private int validateTryNumber(String tryNumber) {
		int number = validateTryNumberIsNumeric(tryNumber);
		return validateTryNumberRange(number);
	}

	private int validateTryNumberRange(int number) {
		if (number < MINIMUM_TRY_NUMBER) {
			throw new IllegalArgumentException(CarRaceMessage.INVALID_TRY_NUMBER);
		}
		return number;
	}

	private int validateTryNumberIsNumeric(String tryNumber) {
		try {
			return Integer.parseInt(tryNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(CarRaceMessage.INVALID_TRY_NUMBER);
		}
	}

}
