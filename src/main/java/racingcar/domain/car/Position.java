package racingcar.domain.car;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public Position getBiggerPosition(Position comparePosition) {
        if (this.position >= comparePosition.position) {
            return this;
        }
        return comparePosition;
    }

    public int getValue() {
        return position;
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
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public void increase() {
        position++;
    }
}
