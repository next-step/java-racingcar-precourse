package racingcar.domain;

public class Car {
    private final CarName carName;
    private final Distance distance;

    public Car(CarName carName) {
        this.carName = carName;
        this.distance = new Distance();
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            distance.increaseDistance();
        }
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public String getDistancePrintMessage() {
        return distance.getDistancePrintMessage();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
