package racingcar.common;

public enum ErrorMessage {
    NAME_TO_LONG("이름은 4이하만 입력 가능합니다."),
    ENERGY_NOT_ACCEPTED("자동차 에너지는 0-9 사이 숫자만 가능합니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String text() {
        return "[ERROR]" + this.value;
    }
}
