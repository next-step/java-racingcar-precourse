package racingcar.domain.car;

import java.util.Objects;
import racingcar.domain.car.accelpower.AccelPowerStrategy;

public class Car {

    private final String name;
    private final Position position;

    public Car(String name) {
        this.name = name;
        this.position = new Position(0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public String getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    public void move(AccelPowerStrategy accelerationPowerStrategy) {
        if (accelerationPowerStrategy.isMove()) {
            position.increase();
        }
    }

    public boolean isLocated(Position comparePosition) {
        return this.position.equals(comparePosition);
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
