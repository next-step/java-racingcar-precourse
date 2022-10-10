package racingcar.common;

public enum ErrorMessage {

    NAME_EMPTY("이름이 비어 있습니다."),
    NAME_GREATER_THEN_MAX_LENGTH("이름은 길이는 5자 이하만 가능합니다."),
    NAME_VALID_FAIL("이름이 비어있지 않은 5자 이하만 가능합니다."),
    TRY_COUNT_NOT_A_NUMBER("시도 횟수는 숫자여야 한다."),
    TRY_COUNT_LESS_THEN_ZERO("시도 횟수는 0회 이상만 가능하다."),
    TRY_COUNT_VALID_FAIL("시도 횟수는 0이상의 숫자만 가능합니다.")
    ;

    private static final String MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return MESSAGE_PREFIX + message;
    }
}
