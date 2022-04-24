package racingcar.dto.response.car;

public class CarName {
    private final String name;

    public CarName(String name) {
        this.name = name;
    }

    public static CarName from(String name) {
        return new CarName(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
