package exception;

public class InvalidCarNameException extends RuntimeException {

	public InvalidCarNameException() {
		super();
	}

	public InvalidCarNameException(final String message) {
		super(message);
	}
}
