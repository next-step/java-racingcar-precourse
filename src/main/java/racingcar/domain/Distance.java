package racingcar.domain;

public class Distance {

    private int value;

    private Distance(int distance) {
        this.value = distance;
    }

    public static Distance fromFactor(int factor) {
        if (MoveState.isIdle(factor)) {
            return MoveState.IDLE.getDistance();
        }
        return MoveState.FORWARD.getDistance();
    }

    public static Distance valueOf(int distance) {
        return new Distance(distance);
    }

    public int toNumber() {
        return value;
    }

    public Distance add(int distance) {
        return new Distance(this.value + distance);
    }

    public Distance add(Distance distance) {
        return add(distance.toNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distance distance = (Distance) o;

        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
