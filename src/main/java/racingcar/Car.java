package racingcar;

public class Car {
    private final CarName name;
    private final Distance travelDistance;

    public Car(final CarName name) {
        this.name = name;
        this.travelDistance = new Distance();
    }

    public CarName getName() {
        return name;
    }

    public Distance getTravelDistance() {
        return travelDistance;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, travelDistance);
    }

    public void travel() {
        travelDistance.inc();
    }
}
