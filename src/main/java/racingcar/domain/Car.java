package racingcar.domain;

import java.util.Objects;

public class Car {

    public static final int MOVE_FORWARD_NUMBER = 4;

    private final CarName name;
    private Position position;

    public Car(String name) {
        this(name, new Position());
    }

    public Car(String name, Position position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public void move(int number) {
        if (number >= MOVE_FORWARD_NUMBER) {
            position.moveForward();
        }
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    public Position maxPosition(Position position) {
        return this.position.maxPosition(position);
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

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
