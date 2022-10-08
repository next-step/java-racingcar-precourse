package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final CarName name;
    private CarPosition position;

    public Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public Car(CarName name) {
        this.name = name;
        this.position = new CarPosition();
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.isMove()) {
            position = position.moveForward();
        }
    }

    public boolean isSamePosition(Car car) {
        return this.position.equals(car.position);
    }

    public CarName getName() {
        return name;
    }

    public CarPosition getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name.toString() + " : " + position.toString();
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
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
