package racingcar.model.enums;

public enum ErrorType {
    INVALID_INPUT_CAR_NAME("[ERROR] 자동차의 이름은 1자 ~ 5자 이하만 가능합니다.");

    final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
