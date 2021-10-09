package racinggame.model.enums;

public enum Error {
    INVALID_CAR_NAME("자동차 이름을 정확히 입력해주세요"),
    INVALID_CAR_NAME_RANGE("자동차 이름은 5자 이하여야 합니다."),
    INVALID_MOVE_CONDITION_RANGE("이동 조건 값은 0 이상 9 이하여야 합니다."),
    INVALID_MOVE_NUMBER_SIZE("자동차의 갯수와 이동 숫자의 갯수가 일치하지 않습니다."),
    INVALID_COUNT("시도 횟수는 0 보다 커야 합니다."),
    INPUT_MUST_NOT_BE_NULL("빈 값을 입력하면 안됩니다."),
    WRONG_NUMBER_FORMAT("숫자를 입력해야 합니다.")
    ;

    private static final String prefix = "[ERROR] ";

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String message() {
        return prefix + message;
    }
}
