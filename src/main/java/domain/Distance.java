package domain;

import java.util.Objects;

public class Distance {
    private int value;

    public static Distance zeroDistance() {
        return new Distance(0);
    }

    public Distance(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void add(Distance distance) {
        this.value += distance.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distance)) return false;
        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
