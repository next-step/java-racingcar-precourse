package racingcar.domain;

import java.util.Objects;

public class Position {
    private final int value;

    public Position(final int value) {
        this.value = value;
    }

    public Position forward() {
        return new Position(this.value + 1);
    }

    public boolean isUpper(final Position position) {
        return this.value > position.value;
    }

    public int value() {
        return this.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
