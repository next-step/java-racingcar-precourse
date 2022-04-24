package racingcar.constant;

public enum ErrorStatus {

    CAR_NAME_OVER_MAXIMUM_LENGTH("이름은 5자 이하여야 합니다."),
    CAR_NAME_PATTERN_NOT_MATCHED("이름은 알파벳과 쉼표(,)로 구분된 입력이어야 합니다."),
    NUMBER_OF_ATTEMPTS_SMALLER_THAN_ONE("시도 횟수는 1보다 같거나 커야 합니다."),
    NUMBER_OF_ATTEMPTS_PATTERN_NOT_MATCHED("시도 횟수는 숫자여야 합니다."),
    STANDARD_OUT_OF_RANGE("전진 조건은 0-9 사이의 랜덤한 정수입니다."),
    INPUT_BLANK("입력은 공백일 수 없습니다."),
    INVALID_CAR_OR_NUMBER("잘못된 입력입니다.");

    private static final String ERROR_PREFIX = "[ERROR]";

    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }

}
