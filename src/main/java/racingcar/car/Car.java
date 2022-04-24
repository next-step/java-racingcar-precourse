package racingcar.car;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Car implements Comparable<Car> {

    private final CarName name;
    private final Position position;

    protected Car(CarName name, Position position) {
        this.name = requireNonNull(name, "name");
        this.position = requireNonNull(position, "position");
    }

    public static Car of(String name) {
        return new Car(CarName.of(name), Position.of());
    }

    public void move() {
        position.increment();
    }

    public String name() {
        return name.value();
    }

    public int position() {
        return position.value();
    }

    @Override
    public boolean equals(Object o) {
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

    @Override
    public int compareTo(Car other) {
        return position.compareTo(other.position);
    }
}
