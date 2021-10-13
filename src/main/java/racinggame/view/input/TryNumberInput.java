package racinggame.view.input;

public class TryNumberInput {
	private static final String INTEGER_ERROR_MASSAGE = "[ERROR] 숫자가 아니거나 너무 큰 숫자입니다.";

	private final int tryNumber;

	public TryNumberInput(final String tryNumber) {
		this.tryNumber = validation(tryNumber);
	}

	public int getTryNumber() {
		return tryNumber;
	}

	private int validation(final String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INTEGER_ERROR_MASSAGE);
		}
	}
}
