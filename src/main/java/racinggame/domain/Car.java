package racinggame.domain;

import racinggame.domain.strategy.MoveStrategy;

import java.util.Objects;

public class Car {

    private Name name;
    private int distance;

    public Car(final String name) {
        this.name = Name.of(name);
    }

    public void move(final MoveStrategy moveStrategy) {
        boolean distance = moveStrategy.move();
        if (distance) {
            this.distance++;
        }
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
