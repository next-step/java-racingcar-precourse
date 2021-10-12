package racinggame.exception;

public class BlankNameException extends IllegalArgumentException {
	private static final String EXCEPTION_MESSAGE = "Name value is not blank.";

	public BlankNameException() {
		super(EXCEPTION_MESSAGE);
	}
}
