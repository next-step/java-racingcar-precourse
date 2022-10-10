package racingcar.domain;

import java.util.Objects;

import static racingcar.exception.ErrorMessage.INVALID_POSITION;

public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(INVALID_POSITION);
        }
        this.position = position;
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

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public Position max(Position maxPosition, Position currentPositon) {
        return new Position(Integer.max(maxPosition.getPosition(), currentPositon.getPosition()));
    }

    public String getCurrentPositionString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
