package racingcar.domain;

import java.util.Objects;

public class Car {
    private final Name name;
    private final Position position;

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Car forward() {
        return new Car(name, position.forward());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
