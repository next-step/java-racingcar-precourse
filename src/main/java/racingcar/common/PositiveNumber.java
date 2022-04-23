package racingcar.common;

public class PositiveNumber {
    private final String NUMBER_CHECK_REGEX = "-?\\d+";

    public final Integer value;

    public PositiveNumber(Integer value) {
        validate(value);
        this.value = value;
    }

    public PositiveNumber(String value) {
        validate(value);
        Integer convertValue = Integer.parseInt(value);
        validate(convertValue);
        this.value = convertValue;
    }

    private void validate(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException("Only positive numbers are allowed");
        }
    }

    private void validate(String value) {
        if (!value.matches(NUMBER_CHECK_REGEX)) {
            throw new IllegalArgumentException("Only numbers are allowed");
        }
    }
}
