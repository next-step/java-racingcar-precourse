package racingcar.domain.car.vo;

import java.util.Objects;

public final class Position {

    private final int value;

    public Position(int value) {
        validationNegative(value);
        this.value = value;
    }

    public static Position zero() {
        return new Position(0);
    }

    public boolean compareTo(Position position) {
        return this.value < position.value;
    }

    public Position increase() {
        return new Position(value + 1);
    }

    public int value() {
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
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void validationNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("[ERROR] Position의 값은 음수가 될 수 없습니다.");
        }
    }
}