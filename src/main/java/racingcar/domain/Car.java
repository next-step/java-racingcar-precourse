package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.Objects;

public class Car {

    private final Name name;
    private Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(MovingStrategy movingStrategy) {
        this.position = position.move(movingStrategy);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position.isMaxPosition(maxPosition);
    }

    public int position() {
        return position.getPosition();
    }

    public String name() {
        return name.getName();
    }

    public Name getName() {
        return name;
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
