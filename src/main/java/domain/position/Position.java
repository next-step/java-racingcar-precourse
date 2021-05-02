package domain.position;

import java.util.Objects;

public class Position implements Comparable {
    private static final int MINIMUM_POSITION = 0;
    private static final int POSITION_INCREASE_COUNT = 1;

    private int position;

    public Position() {
        this(MINIMUM_POSITION);
    }

    public Position(int position) {
        if (position < MINIMUM_POSITION) {
            throw new IllegalArgumentException("위치는 0 이하가 없습니다.");
        }

        this.position = position;
    }

    public Position increase() {
        return new Position(position + POSITION_INCREASE_COUNT);
    }

    public int toInt() {
        return position;
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

    @Override
    public int compareTo(Object o) {
        Position dest = (Position) o;

        if (dest.toInt() > toInt()) {
            return -1;
        } else if (dest.toInt() < toInt()) {
            return 1;
        }

        return 0;
    }
}
