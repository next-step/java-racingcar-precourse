package racinggame.exception;

public class InvalidPositionException extends RuntimeException {

	public static final String INVALID_POSITION = "자동차의 위치는 0보다 작을 수 없습니다.";

	public InvalidPositionException() {
		super(INVALID_POSITION);
	}
}
