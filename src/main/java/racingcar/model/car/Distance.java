package racingcar.model.car;

public class Distance {
    protected int distance;

    public Distance() {
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        this.distance++;
    }
}
