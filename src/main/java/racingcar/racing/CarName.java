package racingcar.racing;

public class CarName {
    private final int MAX_NAME_LENGTH = 5;

    private final String value;

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("The name of the car must be 5 characters or less.");
        }

        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty names are not allowed.");
        }
    }
}
