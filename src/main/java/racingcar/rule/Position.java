package racingcar.rule;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int DEFAULT = 0;

    private int value;

    public Position(int position) {
        validateMin(position);
        this.value = position;
    }

    private void validateMin(int position) {
        if (position < DEFAULT) {
            final String message = String.format("위치는 %d 이상이어야 한다.", DEFAULT);
            throw new IllegalArgumentException(message);
        }
    }

    public static Position init() {
        return new Position(DEFAULT);
    }

    public void increase() {
        value += 1;
    }

    public int get() {
        return value;
    }

    public Position copy() {
        return new Position(value);
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
