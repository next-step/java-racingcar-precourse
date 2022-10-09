package racingcar.model.cars.factory;

public class Title {
    private final String title;

    public Title(String carName) {
        this.title = carName;
    }

    public String get() {
        return title;
    }
}
