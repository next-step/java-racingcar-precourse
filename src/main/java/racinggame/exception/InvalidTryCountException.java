package racinggame.exception;

public class InvalidTryCountException extends RuntimeException {

	public static final String INVALID_TRY_COUNT = "시도횟수는 0보다 작을 수 없습니다.";

	public InvalidTryCountException() {
		super(INVALID_TRY_COUNT);
	}
}
