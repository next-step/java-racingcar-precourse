package racingcar.model;

import java.util.Objects;

public class Position implements Comparable {

    private int position = 0;

    public int get() {
        return this.position;
    }

    public void increase() {
        this.position++;
    }

    public boolean isSameWith(int maxPosition) {
        if (this.position == maxPosition) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        Position p = (Position) o;
        if (this.position < p.position) {
            return -1;
        }
        return this.position - p.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
