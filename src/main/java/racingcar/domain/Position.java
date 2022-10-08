package racingcar.domain;

import java.util.Objects;

public class Position {

    private int positionNumber = 0;

    public Position() {
    }

    public void increase() {
        positionNumber++;
    }

    public boolean lessThan(final Position position) {
        return this.positionNumber < position.positionNumber;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return positionNumber == position.positionNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionNumber);
    }
}
