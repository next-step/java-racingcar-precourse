package racingcar;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_POSITION_SIZE = 0;

    private Position position;
    private Name name;

    public Car(Position position, Name name) {
        this.position = position;
        this.name = name;
    }

    public Car(Name name) {
        this.name = name;
        this.position = new Position(DEFAULT_POSITION_SIZE);
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public void move(MovableStrategy movableStrategy) {
        if (!movableStrategy.isMovable()){
            return;
        }
        position = position.increase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
