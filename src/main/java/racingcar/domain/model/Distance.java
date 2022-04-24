package racingcar.domain.model;

import racingcar.core.common.error.DistanceErrorCode;

public class Distance {

    private static final int MIN_DISTANCE_VALUE = 0;

    private int distance;

    public Distance() {
        this.distance = MIN_DISTANCE_VALUE;
    }

    public Distance(int distance) {
        validatePositiveValue(distance);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void increase() {
        distance++;
    }

    private void validatePositiveValue(int distance) {
        if (distance < MIN_DISTANCE_VALUE) {
            throw new IllegalArgumentException(DistanceErrorCode.ONLY_ALLOW_POSITIVE_VALUE.getErrorMessage());
        }
    }
}
