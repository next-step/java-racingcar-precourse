package racingcar.domain;

import java.util.Objects;

public class Car {
    private Name name;
    private Distance distance;

    public Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance();
    }

    public Name getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    public void move(Distance distance) {
        this.distance.addDistance(distance);
    }
}
