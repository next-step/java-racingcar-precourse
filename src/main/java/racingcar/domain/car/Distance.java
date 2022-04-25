package racingcar.domain.car;

import racingcar.common.error.ErrorMessage;

public class Distance implements Comparable<Distance> {
    private static final int MIN_DISTANCE = 0;
    private int distance;

    private Distance(int distance) {
        this.distance = distance;
        validate();
    }

    public static Distance from(int distance) {
        return new Distance(distance);
    }

    private void validate() {
        if (this.distance < MIN_DISTANCE) {
            throw new IllegalArgumentException(ErrorMessage.MSG_INVALID_DISTANCE.getMessage());
        }
    }

    @Override
    public int compareTo(Distance target) {
        return distance - target.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Distance that = (Distance) o;
        return distance == that.distance;
    }

    public int toInteger() {
        return distance;
    }

    public void add(Distance target) {
        distance = distance + target.toInteger();
    }

}
