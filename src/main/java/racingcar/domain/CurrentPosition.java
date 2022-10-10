package racingcar.domain;

import java.util.Objects;

public class CurrentPosition {
    private static final String INVALID_CURRENT_POSITION_ERROR_MESSAGE = "위치는 0보다 작을 수 없습니다.";
    private int value;

    public CurrentPosition(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(INVALID_CURRENT_POSITION_ERROR_MESSAGE);
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void increasePosition() {
        value++;
    }

    public int compareTo(int input) {
        return value - input;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentPosition that = (CurrentPosition) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
