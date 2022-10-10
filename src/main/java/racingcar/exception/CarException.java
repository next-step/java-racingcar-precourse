package racingcar.exception;

public class CarException extends RuntimeException {
	private static String error = "[ERROR] ";

	public CarException(String message) {
		super(error + message);
	}
}
