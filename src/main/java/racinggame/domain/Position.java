package racinggame.domain;

import java.util.Objects;

public class Position {
    private int position = 0;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position은 0 이상의 값만 등록 가능합니다.");
        }
        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public int getMaxPosition(int max) {
        return Math.max(this.position, max);
    }

    public String getPositionToBar() {
        String result = "";
        for (int i = 0; i < position; i++)
            result += "-";
        return result;
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
