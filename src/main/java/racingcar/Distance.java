package racingcar;

import java.util.Collections;

public class Distance implements Comparable<Distance> {
    private int distance;
    public static final int DEFAULT_DISTANCE = 0;

    public Distance() {
        distance = DEFAULT_DISTANCE;
    }

    public int getNumericDistance() {
        return distance;
    }

    public void increase() {
        distance++;
    }

    public String toDashMarkup() {
        return String.join("", Collections.nCopies(distance, "-"));
    }

    @Override
    public int compareTo(Distance other) {
        if (distance > other.getNumericDistance()) {
            return 1;
        } else if (distance < other.getNumericDistance()) {
            return -1;
        } else {
            return 0;
        }
    }
}
