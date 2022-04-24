package racingcar;

import java.util.Objects;

public class Distance implements Comparable<Distance> {
    int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void addMove() {
        distance++;
    }

    @Override
    public int compareTo(Distance obj) {
        return getDistance() - obj.getDistance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Distance)) {
            return false;
        }

        Distance distance1 = (Distance) o;
        return getDistance() == distance1.getDistance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

}
