package racingcar.domain;

public class Position implements Comparable<Position> {

    private static final StringBuilder stringBuilder = new StringBuilder();
    private int distance;

    public Position() {
        this.distance = 0;
    }

    public void goForwardOneStep() {
        distance++;
    }

    @Override
    public String toString() {
        stringBuilder.setLength(0);

        for (int i = 0; i < distance; i++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Position o) {
        return this.distance - o.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Position position = (Position) o;

        return distance == position.distance;
    }

    @Override
    public int hashCode() {
        return distance;
    }
}
