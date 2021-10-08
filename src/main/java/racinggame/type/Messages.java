package racinggame.type;

public enum Messages {
    ERROR_SEED_NOT_IN_RANGE("시드값은 0 이상 9 이하의 정수여야 합니다."),
    ERROR_NAME_TOO_LONG_OR_EMPTY("이름은 1자이상 5자 이하여야 합니다."),
    ERROR_INVALID_CAR_NAME("CarName은 비어있을 수 없습니다."),
    ERROR_TRYTIMES_MUST_BE_GREATER_THAN_ZERO("시도 횟수는 최소 0 이상이어야 합니다."),
    ERROR_STRING_CANNOT_CONVERT_TO_INT("올바른 숫자 입력이 아닙니다."),
    INFO_REQUIRE_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INFO_REQUIRE_TRY_TIMES("시도할 회수는 몇회인가요?");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
