package racingcar.domain;

import java.util.Objects;

public class Car {
    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String printCurrentPosition() {
        return name + " : " + position.print();
    }

    public String printName() {
        return name.toString();
    }

    public Position getMaxPosition(Position maxPosition) {
        return position.max(maxPosition);
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
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

    public void move() {
        position.move();
    }
}
