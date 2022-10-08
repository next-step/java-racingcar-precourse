package racingcar.domain;

public class Car {
    private final CarName name;
    private final Positive distance;

    public Car(final CarName name, final Positive distance) {
        this.name = name;
        this.distance = distance;
    }

    public Car(final CarName name) {
        this(name, new Positive());
    }

    public Car(final String name) {
        this(new CarName(name));
    }

    public CarName getName() {
        return this.name;
    }

    public Positive getDistance() {
        return this.distance;
    }

    public void racing(final MovingStrategy movingStrategy) {
        if (movingStrategy.move()) {
            this.distance.plus();
        }
    }
}
