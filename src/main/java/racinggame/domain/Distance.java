package racinggame.domain;

public class Distance {

    private final int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public String getDistanceView() {
        String distanceView = "";
        for (int i = 0; i < this.distance; i++) {
            distanceView += "-";
        }
        return distanceView;
    }

    public Distance increase(int interval) {
        return new Distance(this.distance + interval);
    }

    public int getDistance() {
        return distance;
    }
}
