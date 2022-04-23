package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int START_POSITION = 0;
    private static final int ADVANCE_NUM = 1;
    private int position;

    public Position() {
        this.position = START_POSITION;
    }

    public void advance() {
        position = position + ADVANCE_NUM;
    }

    public int getPosition() {
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
        Position position1 = (Position) o;
        return getPosition() == position1.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
