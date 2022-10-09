package racingcar.domain;

import racingcar.constant.Error;

public class CarName {
    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validate(String name) {
        validateEmpty(name);
        validateLength(name);
    }

    private void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(Error.EMPTY_NAME.toString());
        }
    }

    private void validateLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(Error.TOO_LONG_NAME.toString());
        }
    }
}
