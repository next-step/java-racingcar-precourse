package racingcar.exception.message;

public enum ErrorMessage {

    NUMBER_INVALID_LENGTH_EXCEPTION("자동차 이름에 유효하지 않은 길이 입니다. 1이상 5이하의 문자열을 입력해주세요."),
    NUMBER_INVALID_CHARACTER_EXCEPTION("자동차 이름에 유효하지 않은 문자가 포함되었습니다. 쉼표(,)는 사용할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
