package racingcar;

public enum ExceptionMessage {

    CAR_NAME_MAX_SIZE("자동차 이름 길이는 5이하만 가능 합니다."),

    CAR_NAME_EMPTY("자동차 이름을 다시 입력해주세요."),

    CAR_NAME_OVERLAY("자동차 이름이 중복되었습니다."),

    GAME_COUNT_EMPTY("시도 횟수를 다시 입력해주세요"),

    GAME_COUNT_NEGATIVE("시도 횟수를 음수로 입력할 수 없습니다."),

    GAME_COUNT_NOT_NUMBER("시도 횟수를 숫자로 입력 해주세요."),

    CAR_MOVE_COUNT("자동차는 0에서 9까지의 값으로만 이동할 수 있습니다.");

    private final String MESSAGE;

    ExceptionMessage(String MESSAGE) {
        this.MESSAGE = "[ERROR] ".concat(MESSAGE);
    }

    String getMessage() {
        return this.MESSAGE;
    }

}
