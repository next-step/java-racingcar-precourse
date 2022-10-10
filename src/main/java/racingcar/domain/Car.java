package racingcar.domain;

import java.util.Objects;

public class Car {
    private final CarName name;
    private Location location;

    public Car(String name) {
        this.name = new CarName(name);
        this.location = new Location();
    }

    public Car(String name, Location location) {
        this.name = new CarName(name);
        this.location = location;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            this.location = location.add();
        }
    }

    public Car whoIsWinner(Car competitor) {
        if (this.location.isGreaterOrEqual(competitor.location)) {
            return this;
        }
        return competitor;
    }

    public boolean isTie(Car winner) {
        return this.location.equals(winner.location);
    }

    public String getName() {
        return name.getName();
    }

    public int getLocation() {
        return location.getLocation();
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
        return Objects.equals(name, car.name) && Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

}
