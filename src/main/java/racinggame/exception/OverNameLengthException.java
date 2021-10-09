package racinggame.exception;

public class OverNameLengthException extends IllegalArgumentException {
	private static final String EXCEPTION_MESSAGE = "Name value length exceeded.";

	public OverNameLengthException() {
		super(EXCEPTION_MESSAGE);
	}
}
