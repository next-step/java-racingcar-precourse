package racinggame.model;

import racinggame.model.enums.Error;

public class CarName {
    private static final int MAX_SIZE = 5;

    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateNull(name);
        validateNameLength(name);
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException(Error.INVALID_CAR_NAME.message());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_SIZE) {
            throw new IllegalArgumentException(Error.INVALID_CAR_NAME_RANGE.message());
        }
    }

    public String getName() {
        return name;
    }
}
