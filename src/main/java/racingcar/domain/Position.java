package racingcar.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException();
        }
        this.position = position;
    }

    public void plus(int num) {
        this.position += num;
    }

    public boolean isMaxPosition(Position maxPosition) {
        return this.position == maxPosition.position;
    }

    public boolean isBiggerPosition(Position otherPosition) {
        return this.position > otherPosition.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
