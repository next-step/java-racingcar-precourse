package racingcar;

import static racingcar.Constants.DISTANCE_NEGATIVE_EXCEPTION_MESSAGE;

public class Distance {
    private int value;

    public Distance(int distance) {
        validateRange(distance);
        this.value = distance;
    }

    public int getValue() {
        return value;
    }

    private void validateRange(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException(DISTANCE_NEGATIVE_EXCEPTION_MESSAGE);
        }
    }

    public void increment() {
        value++;
    }
}
