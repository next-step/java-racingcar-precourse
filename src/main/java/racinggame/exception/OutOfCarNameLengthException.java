package racinggame.exception;

public class OutOfCarNameLengthException extends RuntimeException {
	public OutOfCarNameLengthException(String errorMessage) {
		super(errorMessage);
	}
}
