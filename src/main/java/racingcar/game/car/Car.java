package racingcar.game.car;

import racingcar.game.Distance;

public class Car {
    private final CarName name;
    private final Distance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new Distance(0);
    }

    public Car(CarName carName) {
        this.name = carName;
        this.distance = new Distance(0);
    }

    public Car(Car car, Distance newDistance) {
        this.name = car.name;
        this.distance = newDistance;
    }

    public Car(Car car) {
        this.name = car.name;
        this.distance = car.distance;
    }

    public CarName getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }

    public Car moved(Distance distance) {
        return new Car(this, getDistance().increased(distance));
    }

    @Override
    public String toString() {
        return getName() + " : " + getDistance() + "\n";
    }
}
