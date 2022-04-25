package racingcar.domain;

public class CarName {

    private String name;

    public CarName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
