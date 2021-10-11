package racinggame.domain;

import java.util.Objects;

public class Position {

    private static final int INITIAL_VALUE = 0;

    private final int value;

    public Position() {
        this.value = INITIAL_VALUE;
    }

    public Position(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
    }

    public Position next() {
        return new Position(this.value + 1);
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
