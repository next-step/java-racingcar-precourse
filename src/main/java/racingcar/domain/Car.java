package racingcar.domain;

import java.util.Objects;

public class Car {
    static final String RACER_EXPRESSION = "%s : %s";
    private final Name name;
    private final Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(Name.from(name), Position.create());
    }

    public String race(Movement movement) {
        if (movement.forward()) {
            position.forward();
        }
        return toString();
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position.get();
    }

    public boolean isWinner(int position) {
        return this.position.match(position);
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
        return String.format(RACER_EXPRESSION, name, position);
    }
}
