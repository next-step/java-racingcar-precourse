package racingcar.domain;

import java.util.Objects;

public class Car {
    private CarName carName;
    private Distance distance;

    public Car(String name) {
        this.carName = new CarName(name);
        this.distance = new Distance();
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public void move(Distance distance) {
        this.distance.addDistance(distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
