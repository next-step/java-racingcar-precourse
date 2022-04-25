package racingcar;

import static racingcar.Constants.NAME_LENGTH_EXCESS_EXCEPTION_MESSAGE;

public class CarName {
    private final String value;

    public CarName(String name) {
        validateNameLength(name);
        this.value = name;
    }

    public String getValue() {
        return value;
    }

    private void validateNameLength(String name) {
        if (name.length() > Constants.NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCESS_EXCEPTION_MESSAGE);
        }
    }
}
