package racingcar.service;

public class CarDistance {
    private static final String INITIAL_DISTANCE = "";
    private static final String EACH_DISTANCE = "-";

    private String distance;

    public CarDistance() {
        this.distance = INITIAL_DISTANCE;
    }

    public void addDistance() {
        this.distance += EACH_DISTANCE;
    }

    public String getDistance() {
        return distance;
    }

    public int getDistanceSize() {
        return distance.length();
    }
}
