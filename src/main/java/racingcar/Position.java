package racingcar;

import java.util.Objects;

public class Position {
    private static final String INVALID_NUMBER_MESSAGE = "[ERROR] 0 이상의 값을 입력하세요.";
    private static final int MIN_NUMBER = 0;

    private final int position;

    public Position(int position) {
        if (position < MIN_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position increase() {
        return new Position(position + 1);
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
