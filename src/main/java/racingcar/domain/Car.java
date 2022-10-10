package racingcar.domain;

import java.util.Objects;

public class Car {
    public static final int MOVING_FORWARD = 4;
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD) {
            this.position.move();
        }
    }

    public boolean compareWinner(Car car) {
        return this.position.isBiggerPosition(car.position);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
