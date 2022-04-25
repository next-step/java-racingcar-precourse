package racingcar.car;

import racingcar.car.strategy.MovingStrategy;
import racingcar.car.strategy.RandomMovingStrategy;

public class CarFactory {

    private final MovingStrategy defaultMovingStrategy;

    public CarFactory() {
        this(new RandomMovingStrategy());
    }

    public CarFactory(MovingStrategy defaultMovingStrategy) {
        this.defaultMovingStrategy = defaultMovingStrategy;
    }

    public Car createCar(CarName carName) {
        return this.createCar(carName, new CarLocation(0), this.defaultMovingStrategy);
    }

    public Car createCar(CarName carName, CarLocation location) {
        return this.createCar(carName, location, this.defaultMovingStrategy);
    }

    public Car createCar(CarName carName, CarLocation carLocation, MovingStrategy movingStrategy) {
        return new Car(carLocation, carName, movingStrategy);
    }
}
