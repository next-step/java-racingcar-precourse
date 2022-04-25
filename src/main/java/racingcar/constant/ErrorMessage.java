package racingcar.constant;

public enum ErrorMessage {
    ERROR_EMPTY_NAME("[ERROR] 자동차 이름을 입력해주세요."),
    ERROR_NAME_LENGTH_OVER("[ERROR] 자동차 이름은 5자 이하를 입력하세요."),
    ERROR_NAME_DUPLICATE("[ERROR] 자동차 이름이 중복됩니다."),
    ERROR_INPUT_NUMBER("[ERROR] 시도 횟수는 숫자를 입력해주세요.");

    ErrorMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
