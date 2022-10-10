package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_MOVE_DISTANCE = 0;
    private static final int NAME_LENGTH_LIMIT = 5;

    private String name;
    private Number moveDistance;

    public Car(String name, int moveDistance) {
        validate(name);
        this.name = name;
        this.moveDistance = new Number(moveDistance);
    }

    public Car(String name) {
        this(name, DEFAULT_MOVE_DISTANCE);
    }

    private void validate(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public void moveForward(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            addMoveDistance();
        }
    }

    private void addMoveDistance() {
        this.moveDistance.plusNumber();
    }

    public int getMoveDistance() {
        return moveDistance.getNumber();
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
        return moveDistance == car.moveDistance && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moveDistance);
    }
}
