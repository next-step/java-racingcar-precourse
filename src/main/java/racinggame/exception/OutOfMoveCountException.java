package racinggame.exception;

public class OutOfMoveCountException extends RuntimeException {
	public OutOfMoveCountException(String errorMessage) {
		super(errorMessage);
	}
}
