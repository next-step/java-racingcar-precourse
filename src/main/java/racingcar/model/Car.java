package racingcar.model;

import java.util.Objects;

public class Car {
    public static final String CAR_STATE_SEPARATOR = " : ";

    private final CarName name;
    private final CarPosition position;

    public Car(CarName name) {
        this.name = name;
        this.position = new CarPosition();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position.moveForward();
        }
    }

    public CarPosition maxPosition(CarPosition comparePosition) {
        return this.position.comparePosition(comparePosition);
    }

    public boolean isWinner(CarPosition maxPosition) {
        return position.isMaxPosition(maxPosition);
    }

    public String getState() {
        return this.name() + CAR_STATE_SEPARATOR + this.position.convertHyphen();
    }

    public String name() {
        return name.getName();
    }

    public CarPosition getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
