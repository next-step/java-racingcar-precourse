package racingcar.model;

import java.util.Objects;

public class Position {
    private static final int START_POSITION_VALUE = 0;

    private int value;

    private Position() {
        value = START_POSITION_VALUE;
    }

    private Position(int value) {
        this.value = value;
    }

    public static Position create() {
        return new Position();
    }

    public static Position valueOf(int value) {
        return new Position(value);
    }

    public void moveValue() {
        this.value++;
    }

    public int getValue() {
        return value;
    }

    public Position getMorePosition(Position position) {
        return this.value > position.getValue() ? this : position;
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
}
