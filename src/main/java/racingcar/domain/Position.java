package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int MIN_NUMBER = 0;
    private static final String ERROR_POSITION_POSITIVE = "위치 값은 양수여야 합니다.";
    private int position;

    public Position() {
        this(MIN_NUMBER);
    }

    public Position(int position) {
        if (position < MIN_NUMBER) {
            throw new IllegalArgumentException(ERROR_POSITION_POSITIVE);
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position movePosition() {
        return new Position(this.position += 1);
    }

    public boolean biggerThan(Position maxPosition) {
        return this.position > maxPosition.position;
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
