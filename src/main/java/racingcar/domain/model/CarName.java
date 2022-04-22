package racingcar.domain.model;

public class CarName {
    private final int MAX_NAME_LENGTH = 5;
    private String name;

    public CarName(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException();
    }

    public String getName() {
        return this.name;
    }
}
