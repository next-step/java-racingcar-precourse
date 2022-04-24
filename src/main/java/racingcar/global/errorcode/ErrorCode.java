package racingcar.global.errorcode;

public enum ErrorCode {

    ILLEGAL_SEPARATOR("이름은 쉼표(,) 기준으로 구분 해야함"),
    ILLEGAL_TEXT_TYPE("이름은 영문만 가능합니다."),
    ILLEGAL_CAR_NULL("차 이름을 입력해주세요."),
    ILLEGAL_CAR_NAME_LENGTH("이름은 5자 이하만 가능합니다."),
    ILLEGAL_TRY_COUNT("시도할 회수는 숫자만 가능합니다."),
    ILLEGAL_MINIMUM_COUNT("시도할 회수는 0보다 커야합니다.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private final String description;

    ErrorCode(String description) {
        this.description = description;
    }

    public String getMessage() {
        return String.format("%s%s", ERROR_MESSAGE_PREFIX, this.description);
    }
}
