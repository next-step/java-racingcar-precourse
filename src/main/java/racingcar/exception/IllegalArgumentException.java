package racingcar.exception;

public class IllegalArgumentException extends RuntimeException{
    public static final String MSG_MAX_LENGTH_CAR_NAME = "[ERROR] 자동차 이름은 5자 이하여야 합니다.";
    public static final String MSG_MIN_LENGTH_CAR_NAME = "[ERROR] 자동차 이름은 1자 이상이여야 합니다.";
    public static final String MSG_NOT_NUMBER = "[ERROR] 시도 횟수는 숫자만 입력할 수 있습니다.";
    public static final String MSG_MIN_ROUND_NUMBER = "[ERROR] 시도 횟수는 1이상 입력할 수 있습니다.";

    public IllegalArgumentException(final String errorMessage) {super(errorMessage);}
}
