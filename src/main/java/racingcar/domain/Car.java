package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final Name name;
    private final Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car fromWithDefaultPosition(Name name) {
        Position position = Position.fromWithDefaultPosition();
        return new Car(name, position);
    }

    public static Car from(Name name, Position position) {
        return new Car(name, position);
    }

    public boolean equalsPosition(Car target) {
        return this.position.equals(target.position);
    }

    public Car moveOrStop(MoveStrategy moveStrategy) {
        Position now = this.position;
        if (moveStrategy.test()) {
            now = this.position.move();
        }
        return from(name, now);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
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

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }
}
