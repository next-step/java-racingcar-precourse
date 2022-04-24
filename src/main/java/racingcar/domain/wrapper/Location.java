package racingcar.domain.wrapper;

public class Location {
    private static final int DEFAULT_DISTANCE = 0;
    private static final String EMPTY = "";
    private static final String DASH = "-";

    private int distance;
    private String dashDistance;

    public Location() {
        distance = DEFAULT_DISTANCE;
        dashDistance = EMPTY;
    }

    public int getDistance() {
        return distance;
    }

    public String getDashDistance() {
        return dashDistance;
    }

    public void moveForward() {
        distance++;
        dashDistance += DASH;
    }
}
