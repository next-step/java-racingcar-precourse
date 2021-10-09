package nextstep.exception;

public class InvalidCarNameException extends RuntimeException {

	public static final String INVALID_CAR_NAME = "자동차의 이름은 0보다 크거나, 5보다 작아야합니다.";

	public InvalidCarNameException() {
		super(INVALID_CAR_NAME);
	}
}
