package racinggame.domain;

public class Car {

    private final CarName name;
    private final CarLocation location;

    private Car(CarName name, CarLocation location) {
        this.name = name;
        this.location = location;
    }

    public static Car from(CarName name) {
        return new Car(name, CarLocation.createLocation());
    }

    public void moveForwardBy(SeedForMove seed) {
        if (seed.shouldMoving()) {
            location.move();
        }
    }

    public CarName getName() {
        return name;
    }

    public CarLocation getLocation() {
        return location;
    }
}
