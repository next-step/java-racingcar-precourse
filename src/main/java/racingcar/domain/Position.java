package racingcar.domain;

import java.util.Objects;

class Position implements Comparable<Position> {
    private int position = 0;

    public void right() {
        this.position += 1;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.position, o.position);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Position))
            return false;
        Position position = (Position) o;
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.position);
    }
}
