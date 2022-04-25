package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Distance {

    private static final int DRIVE = 1;

    private static final int MIN_DISTANCE = 0;

    private static final int MAX_DISTANCE = 9;

    private static final int MOVING_DISTANCE = 4;

    private static final String DISPLAY_DISTANCE = "-";

    private int distance;

    public Distance() {
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public String displayDistance() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.distance; i++) {
            sb.append(DISPLAY_DISTANCE);
        }
        return sb.toString();
    }

    public String moveOrStop() {
        if (Randoms.pickNumberInRange(MIN_DISTANCE, MAX_DISTANCE) >= MOVING_DISTANCE) {
            this.distance += DRIVE;
        }
        return displayDistance();
    }
}
