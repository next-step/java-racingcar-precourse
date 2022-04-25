package racingcar.domain;

public class CarName {

    private final String name;

    public CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    public String getName() {
        return name;
    }
}
