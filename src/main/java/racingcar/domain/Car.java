package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;

    private final Distance distance;

    public Car(String name) {
        this.name = name;
        this.distance = new Distance();
    }

    public String moveOrStop() {
        return this.distance.moveOrStop();
    }

    public String getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Car o) {
        return this.distance.getDistance() - o.distance.getDistance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
