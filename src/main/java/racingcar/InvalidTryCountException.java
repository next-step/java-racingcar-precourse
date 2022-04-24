package racingcar;

public class InvalidTryCountException extends IllegalArgumentException {

    public InvalidTryCountException(String value) {
        super(String.format("올바르지 않은 시도 횟수 값입니다. (입력값: %s)", value));
    }
}
