package racingcar.domain;

public class Car {
    private final CarName carName;
    private final CarPosition carPosition;

    public Car(String name) {
        carName = new CarName(name);
        carPosition = new CarPosition();
    }

    public CarName getCarName() {
        return carName;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }
}
