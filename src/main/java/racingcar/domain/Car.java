package racingcar.domain;

public class Car {
    private final CarName name;
    final CarLocation location;

    public Car(String name) {
        this.name = new CarName(name);
        this.location = new CarLocation();
    }

    public String getName() {
        return name.getName();
    }

    public String getLocation() {
        return location.getLocation().toString();
    }
}
