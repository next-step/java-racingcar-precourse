package racingcar.view;

public enum ErrorMessage {
    ERROR_INPUT_CARNAME("자동차 이름은 1자 이상, 5자 이하로 입력해주세요."),
    ERROR_INPUT_MOVECOUNT("숫자를 입력해주세요."),
    ERROR_INPUT_CARPOSITION("자동차 위치는 0 이상의 숫자로 입력해주세요."),
    ERROR_INPUT_CARCOUNT("최소 2대 이상의 자동차 이름을 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
