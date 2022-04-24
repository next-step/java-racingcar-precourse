package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int INCREASE_AMOUNT = 1;
    private static final int INITIAL_POSITION = 0;
    private int value;

    public Position() {
        this.value = INITIAL_POSITION;
    }

    public int getValue() {
        return value;
    }

    public void increase() {
        this.value += INCREASE_AMOUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return getValue() == position.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
