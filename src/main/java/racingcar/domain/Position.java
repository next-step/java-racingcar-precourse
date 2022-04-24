package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final Integer DEFAULT_POSITION = 0;
    private static final int STEP = 1;

    private final Integer position;

    private Position(Integer position) {
        this.position = position;
    }

    public static Position from(Integer position) {
        return new Position(position);
    }

    public static Position fromWithDefaultPosition() {
        return new Position(DEFAULT_POSITION);
    }

    public Position move() {
        return new Position(this.position + STEP);
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return Objects.equals(position, position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position o) {
        return this.position - o.position;
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
