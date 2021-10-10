package nextstep.domain;

import java.util.Objects;

public class Distance {

    private static final int DEFAULT_DISTANCE = 0;

    private int distance;

    public static Distance zero() {
        return new Distance(DEFAULT_DISTANCE);
    }

    public Distance(int distance) {
        this.distance = distance;
    }

    public void increase() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }

    public int getGreaterDistance(int distance) {
        if (distance <= this.distance) {
            return this.distance;
        }
        return distance;
    }

    public boolean isEqual(int distance) {
        return this.distance == distance;
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
