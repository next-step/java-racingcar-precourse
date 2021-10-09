package racinggame.domain;

public class Car {

    private CarName carName;
    private CarPosition carPosition;

    public Car(CarName carName) {
        this.carName = carName;
        this.carPosition = new CarPosition();
    }

    public CarName getCarName() {
        return carName;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }

    public void move() {
        this.carPosition = CarPosition.addValue(carPosition.getValue());
    }

    public static Car of(CarName carName) {
        return new Car(carName);
    }

}
