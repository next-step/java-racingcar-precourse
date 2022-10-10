package racingcar.domain.car;

import racingcar.contant.ExceptionMessage;
import racingcar.contant.RacingCarConstant;

public class Car {
    public static final int MOVABLE_FUEL = 4;
    private final Name name;
    private Distance distance;

    private Car(String name) {
        this.name = Name.from(name);
        this.distance = Distance.init();
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public Name getName() {
        return this.name;
    }

    public void move(int fuel) {
        validateCarFuel(fuel);
        if (fuel >= MOVABLE_FUEL) {
            this.distance.increase();
        }
    }

    private void validateCarFuel(int input) {
        if (input < RacingCarConstant.CAR_MIN_FUEL || input > RacingCarConstant.CAR_MAX_FUEL) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_FUEL);
        }
    }

    public Distance getDistance() {
        return this.distance;
    }

    public Car findWinner(Car car) {
        if (this.distance.greaterThanOrEqual(car.getDistance())) {
            return this;
        }
        return car;
    }

    public boolean isSameDistance(Car car) {
        return this.distance.equals(car.distance);
    }
}
