package nextstep.exception;

public class InvalidTryCountInputException extends RuntimeException {

	public static final String INVALID_TRY_COUNT_INPUT = "숫자형태만 입력할 수 있습니다.";

	public InvalidTryCountInputException() {
		super(INVALID_TRY_COUNT_INPUT);
	}
}
