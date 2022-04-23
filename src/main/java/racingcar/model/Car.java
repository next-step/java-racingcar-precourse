package racingcar.model;

public class Car {
    private final CarName name;

    private Car(String name) {
        this.name = new CarName(name);
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public String getName() {
        return this.name.getName();
    }
}
