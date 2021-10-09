package racinggame.exception;

public class InvalidPositionValueException extends IllegalArgumentException {
	private static final String EXCEPTION_MESSAGE_FORMAT = "Invalid Position value. The value must be greater than or equal to %d.";

	public InvalidPositionValueException(int minimumValueOfPosition) {
		super(String.format(EXCEPTION_MESSAGE_FORMAT, minimumValueOfPosition));
	}
}
