package racingcar.domain;

import static racingcar.utils.RacingCarConstants.DISTANCE_PRINT_CHARACTER;

public class Distance {
    private int distance;

    public Distance() {
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    public void increaseDistance() {
        this.distance++;
    }

    public String getDistancePrintMessage() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append(DISTANCE_PRINT_CHARACTER);
        }
        return sb.toString();
    }
}
