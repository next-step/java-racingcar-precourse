package racingcar.domain.car;

import java.util.Objects;
import racingcar.domain.car.vo.Name;
import racingcar.domain.car.vo.Position;

public final class Car {

    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car move() {
        return new Car(name, position.increase());
    }

    public int positionValue() {
        return position.value();
    }

    public String nameValue() {
        return name.value();
    }

    public Position position() {
        return position;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
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
