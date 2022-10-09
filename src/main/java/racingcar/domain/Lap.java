package racingcar.domain;

import java.util.Objects;

public class Lap {
    private static final int MIN = 1;
    static final String INVALID_RANGE_MESSAGE = String.format("시도할 횟수를 %d ~ %d 사이의 숫자로 입력해주세요.",
                                                              MIN, Integer.MAX_VALUE);

    private final int value;

    private Lap(int value) {
        this.value = value;
    }

    public static Lap from(String text) {
        int value = convertToInteger(text);
        validate(value);
        return new Lap(value);
    }

    private static int convertToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }

    private static void validate(int value) {
        if (value < MIN) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }

    public int get() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lap lap = (Lap) o;
        return value == lap.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
