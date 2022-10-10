package racingcar.car.domain;

import java.util.Objects;

public class Car {

    private final CarName carName;
    private CarPosition carPosition;
    private final MoveStrategy moveStrategy;

    public Car(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
        this.moveStrategy = new MoveStrategy();
    }

    public CarPosition carPosition() {
        return carPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car that = (Car) o;
        return this.carName.equals(that.carName) && this.carPosition.equals(that.carPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.carName, this.carPosition);
    }

    public void move(int number) {
        if (movable(number)) {
            this.carPosition = this.carPosition.move();
        }
    }

    public boolean movable(int number) {
        return this.moveStrategy.movable(number);
    }

    public String carName() {
        return this.carName.name();
    }
}
