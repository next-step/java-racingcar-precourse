package racingcar.model;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private int value;

    public Position() {
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    public void increment() {
        this.value++;
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

    @Override
    public int compareTo(Position position) {
        if (this.value >= position.value) {
            return 1;
        }
        return -1;
    }
}
