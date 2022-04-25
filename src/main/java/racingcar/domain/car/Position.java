package racingcar.domain.car;

import java.util.Objects;

public class Position {

    private final int DEFAULT_POSITON_DISTANCE = 0;
    private int position = DEFAULT_POSITON_DISTANCE;

    public static Position of() {
        return new Position();
    }

    public void forward(boolean moveAble) {
        if (moveAble) {
            position++;
        }
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }

    public boolean comparePosition(Position o) {
        return this.position > o.position;
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
