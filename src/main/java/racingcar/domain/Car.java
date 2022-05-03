package racingcar.domain;

import java.util.Objects;

public class Car {

    private final Name name;

    private Position position;

    private final MoveStrategy strategy;

    public Car(String name, int step, MoveStrategy strategy) {
        this(name, strategy);
        this.position = new Position(step);
    }

    public Car(Name name, Position position, MoveStrategy strategy) {
        validateMoveStrategy(strategy);
        this.name = name;
        this.position = position;
        this.strategy = strategy;
    }

    public Car(String name, MoveStrategy strategy) {
        validateMoveStrategy(strategy);
        this.name = new Name(name);
        this.position = new Position();
        this.strategy = strategy;
    }

    private void validateMoveStrategy(MoveStrategy strategy) {
        if (Objects.isNull(strategy)) {
            throw new IllegalArgumentException("MoveStrategy must be not null");
        }
    }

    public Car move() {
        Position movedPosition = strategy.move(this.position);
        return new Car(name, movedPosition, strategy);
    }

    public boolean isMoved(Car beforeCar) {
        if (this.equals(beforeCar)) {
            return false;
        }
        return true;
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

}
