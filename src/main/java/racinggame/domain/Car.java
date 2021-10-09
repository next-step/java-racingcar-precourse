package racinggame.domain;

import racinggame.domain.strategy.MoveStrategy;

import java.util.Objects;

public class Car {

    private Name name;
    private Distance distance;

    public Car(final String name) {
        this.name = Name.of(name);
        this.distance = Distance.of(0);
    }

    public void move(final MoveStrategy moveStrategy) {
        boolean isMovable = moveStrategy.move();
        if (isMovable) {
            this.distance = Distance.move(this.distance);
        }
    }

    public Name getName() {
        return Name.of(this.name);
    }

    public Distance getDistance() {
        return Distance.of(this.distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
