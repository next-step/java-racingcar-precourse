package racingcar.car;

class Position implements Comparable<Position> {

    private int value;

    protected Position(int value) {
        this.value = value;
    }

    public static Position of() {
        return new Position(0);
    }

    public void increment() {
        value++;
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(other.value, value);
    }
}
