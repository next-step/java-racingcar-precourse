package racinggame.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int INITIAL_VALUE = 0;
    private static final String ERROR_INVALID_POSITION = "[ERROR] 위치는 0보다 작거나 같을 수 없습니다.";

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
            throw new IllegalArgumentException(ERROR_INVALID_POSITION);
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

    @Override
    public int compareTo(final Position o) {
        return this.value != o.value ? ((this.value > o.value) ? 1 : -1) : 0;
    }
}
