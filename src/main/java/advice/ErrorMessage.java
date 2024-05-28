package advice;

public enum ErrorMessage {

    CAR_NAME_OUT_OF_RANGE("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다."),
    CAR_NAME_DUPLICATE("[ERROR] 자동차 이름은 중복될 수 없습니다."),
    CAR_COUNT_LESS_THAN_TWO("[ERROR] 자동차는 2대 이상이어야 합니다."),
    ATTEMPT_COUNT_NOT_INTEGER("[ERROR] 시도 횟수는 정수여야 합니다."),
    ATTEMPT_COUNT_MUST_BE_AT_LEAST_ONE("[ERROR] 시도 횟수는 1 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
