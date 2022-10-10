package racingcar.domain;

public class Distance {

    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public void increase() {
        distance++;
    }

    public boolean isMoveMoreThen(Distance other) {
        return this.distance > other.distance;
    }

    public boolean isSameDistance(Distance other) {
        return this.distance == other.distance;
    }

    public int getDistance() {
        return distance;
    }
}
