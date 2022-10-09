package racingcar.constant;

public enum Error {
    EMPTY_NAME("자동차 이름은 공백일 수 없다."),
    DUPLICATE_NAME("자동차 이름은 중복될 수 없다."),
    TOO_LONG_NAME("자동차의 이름은 5자를 초과할 수 없다."),
    INVALID_INTEGER("시도 횟수는 숫자여야 한다."),
    SHOULD_OVER_MINIMUM_ROUND("시도 횟수는 0보다 커야한다.");

    private static final String PREFIX = "[ERROR] ";

    private final String description;

    Error(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return Error.PREFIX + description;
    }
}
