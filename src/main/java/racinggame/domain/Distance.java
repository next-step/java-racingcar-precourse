package racinggame.domain;

import java.util.Objects;

public class Distance {

    private final int distance;

    private Distance(final int distance) {
        this.distance = distance;
    }

    public static Distance of(final int distance) {
        return new Distance(distance);
    }

    public static Distance move(final Distance distance) {
        return new Distance(distance.distance + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
