package racingcar.model;

public class Distance {
    private static final String HYPHEN = "-";

    private StringBuilder distance;

    public Distance() {
        this.distance = new StringBuilder();
    }

    public void increaseDistance() {
        this.distance.append(HYPHEN);
    }

    public String getPosition() {
        return distance.toString();
    }

    public int getDistance() {
        return distance.length();
    }
}
