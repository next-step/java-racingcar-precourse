package racingcar.domain;

public class CarName {
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private final String value;

    public CarName(final String value) {
        validateCarNameLength(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validateCarNameLength(final String value) {
        if (value == null || value.trim().isEmpty() || value.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("올바른 자동차 이름 입력이 아닙니다.");
        }
    }
}
