package racingcar.model.car;

import racingcar.model.car.wrap_variable.Distance;
import racingcar.model.car.wrap_variable.Name;

public class Car {
    private Name name;
    private Distance distance;

    public Car() {
    }

    public Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance();
    }

    public Car(String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public void setName(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return this.name.getName();
    }

    public Distance getDistance() {
        return this.distance;
    }

    public void move() {
        this.distance.plusDistance();
    }
}
