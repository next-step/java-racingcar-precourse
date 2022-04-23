package racingcar.domain;

import static racingcar.utils.WordUtils.DASH;

public class Distance {
    private int distanceCount;
    private String distanceLine;

    public Distance() {
        this.distanceCount = 0;
        this.distanceLine = "";
    }

    public int getDistanceCount() {
        return distanceCount;
    }

    public String getDistanceByDash() {
        return distanceLine;
    }

    public void advance() {
        this.distanceCount++;
        this.distanceLine += DASH;
    }
}
