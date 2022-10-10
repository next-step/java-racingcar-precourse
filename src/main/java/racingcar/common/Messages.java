package racingcar.common;

public enum Messages {

    RESULT_EXECUTE("실행 결과"),
    WINNERS("최종 우승자 : "),

    PLEASE_INPUT_CAR_NAMES("경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    PLEASE_INPUT_RACE_COUNT("시도할 회수는 몇회인가요?"),

    ERROR_EMPTY_RACE_COUNT("이동 횟수가 입력되지 않았습니다."),
    ERROR_EMPTY_CAR_NAMES("참가할 자동차 이름이 입력되지 않았습니다."),
    ERROR_INVALID_RACE_COUNT("숫자가 아닌 문자는 입력할 수 없습니다."),
    ERROR_EMPTY_CAR_NAME("공백인 자동차 이름을 입력할 수 없습니다."),
    ERROR_LENGTH_CAR_NAME("자동차 이름의 길이는 5글자 이하여야 합니다."),

    HYPHEN("-"),
    COLON(" : "),
    COMMA(","),
    BLANK(" "),
    EMPTY(""),
    ZERO("0"),
    ERROR("[ERROR] ");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public void println() {
        System.out.println(message);
    }

    public void println(String append) {
        System.out.println(message + append);
    }

    public String toString() {
        return message;
    }

    public boolean equals(String compare) {
        return message.equals(compare);
    }
}
