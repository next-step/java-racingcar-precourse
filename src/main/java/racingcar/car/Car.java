package racingcar.car;

import racingcar.car.strategy.MovingStrategy;

public class Car implements Comparable<Car> {

    private CarLocation location;
    private CarName carName;
    private MovingStrategy movingStrategy;

    Car(CarLocation location, CarName carName, MovingStrategy movingStrategy) {
        this.location = location;
        this.carName = carName;
        this.movingStrategy = movingStrategy;
    }

    public CarName carName() {
        return this.carName;
    }

    public CarLocation location() {
        return this.location;
    }

    public void tryMove() {
        if (this.movingStrategy.canMove()) {
            this.location.addLocation(1);
        }
    }

    @Override
    public int compareTo(Car o) {
        return this.location.compareTo(o.location);
    }
}
