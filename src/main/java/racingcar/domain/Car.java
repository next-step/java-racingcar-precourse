package racingcar.domain;

public class Car {
    private final CarName name;
    private final int distance;

    public Car(CarName name) {
        this.name = name;
        this.distance = 0;
    }

    public Car(CarName name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name.getCarName();
    }

    public int getDistance() {
        return distance;
    }

    public Car increaseDistance() {
        return new Car(name, distance + 1);
    }
}
