package racinggame.domain;

import java.util.Objects;

public class Car {

    private final CarName carName;
    private Distance distance;

    public Car(CarName carName) {
        this.carName = carName;
        this.distance = new Distance(0);
    }

    public void move(int interval) {
        this.distance = this.distance.increase(interval);
    }

    public String getCarStatus() {
        return this.carName.getName() +
                " : " +
                this.distance.getDistanceView();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carName.equals(car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName.getName());
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
