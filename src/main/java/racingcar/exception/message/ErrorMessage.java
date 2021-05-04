package racingcar.exception.message;

public enum ErrorMessage {
    NAME_INVALID_LENGTH_EXCEPTION("자동차 이름에 유효하지 않은 길이 입니다. 1이상 5이하의 문자열을 입력해주세요."),
    NAME_INVALID_CHARACTER_EXCEPTION("자동차 이름에 유효하지 않은 문자가 포함되었습니다. 쉼표(,)는 사용할 수 없습니다."),
    NAME_DUPLICATE_EXCEPTION("중복되는 자동차 이름이 존재합니다. 자동차 이름은 유일해야 합니다."),
    CARS_INVALID_COUNT_EXCEPTION("유효하지 않은 자동차수 입니다. 1개 이상의 자동차를 입력해 주세요."),
    ROUND_NUMBER_FORMAT_EXCEPTION("실행횟수에는 정수만 입력 가능합니다."),
    ROUND_INVALID_RANGE_EXCEPTION("최소 1회 이상의 실행횟수를 입력해주세요"),
    ROUND_EXCEED_EXECUTABLE_NUMBER("실행가능 횟수를 초과 하였습니다."),
    UN_RECORDABLE_TYPE_EXCEPTION("기록 불가능한 타입입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
