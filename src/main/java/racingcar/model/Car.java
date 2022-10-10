package racingcar.model;

public class Car {
    public static final int MIN_STOP = 0;
    public static final int MIN_FORWARD = 4;
    public static final int MAX_FORWARD = 9;

    private final CarName name;
    private final Distance distance;

    public Car(CarName name) {
        this.name = name;
        this.distance = new Distance();
    }

    public void run(int moveScore) {
        if (moveScore >= MIN_STOP && moveScore <= MAX_FORWARD) {
            move(moveScore);
        }
    }

    private boolean isMove(int movementScore) {
        return movementScore >= MIN_FORWARD;
    }

    private void move(int movementScore) {
        if (isMove(movementScore)) {
            distance.increase();
        }
    }

    public String toStringCarDistance() {
        return name.getCarNameValue() + " : " + distance.toStringDistanceShape();
    }

    public CarName getCarName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }
}
