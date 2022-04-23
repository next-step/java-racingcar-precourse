package racingcar.model;

public class CarDistance {

    private static final int NUMBER_TO_INCREASE = 1;

    private int distance;

    public CarDistance(int distance) {
        this.distance = distance;
    }

    public void increaseDistance() {
        distance += NUMBER_TO_INCREASE;
    }

    public int getDistance() {
        return distance;
    }

}
