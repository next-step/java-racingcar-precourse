package racingcar.referee.domain;

import java.util.Objects;

public class MovingNumber {

    private static final String MOVING_NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 이동 횟수는 0보다 작을 수 없습니다.";
    public static final int SUBTRACT_NUMBER = 1;
    private final int number;

    public MovingNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(MOVING_NUMBER_SIZE_ERROR_MESSAGE);
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovingNumber that = (MovingNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public MovingNumber subtract() {
        return new MovingNumber(this.number - SUBTRACT_NUMBER);
    }
}
