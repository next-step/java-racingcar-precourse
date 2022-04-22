package racingcar.domain;

public class Distance {

    private final int value;

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

    public String getValueAsSymbol() {
        StringBuilder mileageSymbol = new StringBuilder();
        for (int i = 0; i < value; i++) {
            mileageSymbol.append("-");
        }
        return mileageSymbol.toString();
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
