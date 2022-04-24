package racingcar.domain;

public enum ErrorMessage {

    CAR_NAMES_INPUT_HAS_NOT_ALLOWED_CHARACTER("[ERROR] 자동차 이름은 공백없이 문자 또는 숫자만 가능합니다"),
    CAR_NAMES_LESS_THAN_TWO("[ERROR] 자동차 이름은 2개 이상이어야 합니다"),
    CAR_NAMES_DUPLICATED("[ERROR] 각 자동차 이름은 중복될 수 없습니다"),
    CAR_NAME_EMPTY_OR_LENGTH_OVER_FIVE("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다"),
    TRY_COUNT_NOT_A_NUMBER("[ERROR] 시도할 횟수는 숫자만 입력이 가능합니다."),
    TRY_COUNT_LESS_THAN_MIN("[ERROR] 시도할 횟수는 1회 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
