package racingcar.dto.response.car;

public class Car {
    private final CarName name;
    private final CarLocation location;

    private Car(String name, int location) {
        this.name = CarName.from(name);
        this.location = CarLocation.from(location);
    }

    public static Car of(String name, int location) {
        return new Car(name, location);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name.toString(), location.toString());
    }
}
