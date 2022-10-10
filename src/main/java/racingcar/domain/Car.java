package racingcar.domain;

public class Car {
    private final CarName carName;
    private final CarPosition carPosition;

    private Car(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static Car of(CarName carName, CarPosition carPosition) {
        return new Car(carName, carPosition);
    }

    public static Car fromName(String name) {
        return new Car(CarName.from(name), new CarPosition());
    }

    public void forward() {
        carPosition.forward();
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return carPosition.getPosition();
    }
}
