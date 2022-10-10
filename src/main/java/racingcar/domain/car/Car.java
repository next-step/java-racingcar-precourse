package racingcar.domain.car;

import static racingcar.utils.ValidationUtils.requireNotNull;

public class Car {
    private final CarName name;
    private final CarMovingStrategy strategy;
    private Distance distanceFromStartingPoint;

    public Car(CarName name, CarMovingStrategy strategy) {
        requireNotNull(name, "The 'name' should not be null!");
        requireNotNull(strategy, "The 'strategy' should not be null!");

        this.name = name;
        this.strategy = strategy;
        this.distanceFromStartingPoint = Distance.ZERO;
    }

    public CarName getName() {
        return this.name;
    }

    public Distance getDistanceFromStartingPoint() {
        return this.distanceFromStartingPoint;
    }

    public void move() {
        this.distanceFromStartingPoint = this.distanceFromStartingPoint.plus(this.strategy.move());
    }
}
