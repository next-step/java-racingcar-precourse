package racingcar.common;

/**
 * @author garden.iee
 */
public class ErrorMessage {

	private final String message;

	private ErrorMessage(String message) {
		this.message = message;
	}

	public static ErrorMessage of(String message) {
		return new ErrorMessage(message);
	}

	@Override
	public String toString() {
		return message;
	}
}