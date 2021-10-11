package racinggame.enums;

public enum ErrorMessageEnum {
    INPUT_CAR_NAME_SIZE_ERROR("[ERROR] 자동차 이름은 1글자 이상, 5글자 이하만 가능합니다."),
    INVALID_TRY_COUNT_ERROR("[ERROR] 시도 횟수는 숫자를 입력해야 합니다.");

    String message;

    ErrorMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
