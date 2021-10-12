package racinggame.domain;

public class Distance {

    private final int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public Distance increase(int interval) {
        return new Distance(this.distance + interval);
    }

    public int getDistance() {
        return distance;
    }
}
