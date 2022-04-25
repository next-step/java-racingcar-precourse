package racingcar.model;

public class Car {
    private Distance distance;
    private CarName name;

    public Car(CarName carName) {
        this.name = carName;
        this.distance = new Distance();
    }

    public void moveForward(CarStatus status) {
        if(status == CarStatus.GO) {
            this.distance.increaseDistance();
        }
    }

    public String getPosition() {
        return distance.getPosition();
    }

    public int getDistance() {
        return distance.getDistence();
    }

    public CarName getName() {
        return name;
    }

}
