package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int NEXT_POSITION_VALUE = 1;
    private static final int MIN_RANGE_OF_POSITION = 0;
    private static final String NEGATIVE_POSITION_ERROR_MSG = "자동차는 전진만 할 수 있습니다.";

    private final int position;

    public Position(int position) {
        if (position < MIN_RANGE_OF_POSITION) {
            throw new IllegalArgumentException(NEGATIVE_POSITION_ERROR_MSG);
        }

        this.position = position;
    }

    public int value() {
        return this.position;
    }

    public Position next() {
        return new Position(position + NEXT_POSITION_VALUE);
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
