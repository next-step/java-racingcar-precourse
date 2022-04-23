package racingcar.model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final CarName name;
    private final CarPosition position;

    private Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition();
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public void move(CarEngine carEngine) {
        int distance = carEngine.run();
        this.position.forward(distance);
    }

    @Override
    public int compareTo(Car o) {
        return this.position.getPosition() - o.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name) && position.equals(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
