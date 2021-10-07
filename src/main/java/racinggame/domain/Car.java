package racinggame.domain;

public class Car {

    private final CarName name;
    private final CarLocation location;

    private Car(CarName name, CarLocation location) {
        this.name = name;
        this.location = location;
    }

    public static Car of(CarName name, CarLocation location) {
        return new Car(name, location);
    }
}
