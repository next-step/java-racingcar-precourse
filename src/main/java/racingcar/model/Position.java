package racingcar.model;

import java.util.Objects;

public class Position {

    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int winnerPosition) {
        this.position = winnerPosition;
    }

    public void move() {
        this.position++;
    }

    public Integer getPosition() {
        return this.position;
    }

    public boolean lessThan(int winnerPosition) {
        return this.position < winnerPosition;
    }

    public boolean isEquals(int winnerPosition) {
        return this.position == winnerPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
