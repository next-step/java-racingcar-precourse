package racingcar.code;

public enum GameRoundErrorCode implements ErrorCode {

    NUMBER("시도 횟수는 숫자만 입력 가능합니다."),

    NULL("시도 횟수는 NULL 값이 불가능합니다."),

    EMPTY("시도 횟수는 공백 값이 불가능합니다."),

    ZERO("시도 횟수는 0회가 불가능합니다.");

    private final String message;

    GameRoundErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
