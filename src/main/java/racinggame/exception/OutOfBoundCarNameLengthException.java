package racinggame.exception;

public class OutOfBoundCarNameLengthException extends RuntimeException {
	public OutOfBoundCarNameLengthException(String errorMessage) {
		super(errorMessage);
	}
}
