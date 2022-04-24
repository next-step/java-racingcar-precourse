package racingcar.car.domain.models;

import java.util.Objects;
import racingcar.car.domain.errors.CarErrors;
import racingcar.car.domain.external.CarMovePolicyStrategy;
import racingcar.util.StringUtils;

public class Car {

    private static final int INITIAL_CAR_POSITION = 0;

    private final CarName name;
    private final CarPosition position;

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new CarPosition(position);
    }

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition(INITIAL_CAR_POSITION);
    }

    private Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public Car moveForward(CarMovePolicyStrategy strategy) {
        validateStrategy(strategy);

        if (strategy.getCarMovePolicy().isMove()) {
            return new Car(name, position.moveForward());
        }
        return this;
    }

    public CarPosition getGreaterCarPosition(CarPosition anotherCarPosition) {
        validate(anotherCarPosition);
        return position.getGreaterCarPosition(anotherCarPosition);
    }

    public boolean hasSamePosition(CarPosition targetPosition) {
        validate(targetPosition);
        return position.equals(targetPosition);
    }

    private void validateStrategy(CarMovePolicyStrategy strategy) {
        if (strategy == null) {
            throw new IllegalStateException(CarErrors.CAR_MOVE_STRATEGY_ERROR);
        }
    }

    private void validate(CarPosition carPosition) {
        if (carPosition == null) {
            throw new IllegalStateException(CarErrors.CAR_POSITION_EMPTY_ERROR);
        }
    }

    public String getCarName() {
        return name.toString();
    }

    @Override
    public String toString() {
        return name.toString()
                + StringUtils.SPACE
                + StringUtils.COLON
                + StringUtils.SPACE
                + position.toString();
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
