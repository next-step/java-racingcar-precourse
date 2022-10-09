package racingcar.car;

import racingcar.move.Movement;

public class Car implements Comparable {

    private final CarName carName;
    private final CarPosition position;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new CarPosition();
    }

    public CarName getCarName() {
        return this.carName;
    }

    public CarPosition getPosition() {
        return this.position;
    }

    public void move(Movement movement) {
        this.position.calculatePosition(movement);
    }

    @Override
    public int compareTo(Object o) {
        Car otherCar = (Car) o;
        CarPosition otherCarPosition = otherCar.getPosition();
        CarPosition carPosition = this.position;
        return Integer.compare(carPosition.getPosition(), otherCarPosition.getPosition());
    }
}
