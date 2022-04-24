package racingcar.model;

public class Car {

    private Distance distance;
    private CarName carName;

    public Car(CarName carName) {
        this.carName = carName;
        this.distance = new Distance();
    }

    public void moveForward(CarStatus status) {
        if (status.isGoForward()) {
            this.distance.increaseDistance();
        }
    }

    public String getPosition() {
        return distance.getPosition();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public CarName getName() {
        return carName;
    }
}
