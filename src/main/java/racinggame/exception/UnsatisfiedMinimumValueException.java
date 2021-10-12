package racinggame.exception;

public class UnsatisfiedMinimumValueException extends IllegalArgumentException {
	private static final String EXCEPTION_MESSAGE_FORMAT = "The value must be at least greater than %d.";

	public UnsatisfiedMinimumValueException(int value) {
		super(String.format(EXCEPTION_MESSAGE_FORMAT, value));
	}
}
