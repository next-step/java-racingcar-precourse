package racingcar.model;

import static racingcar.common.ErrorMessage.NAME_TO_LONG;

public class CarName {
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(name.length() > NAME_MAX_LENGTH)
            throw new IllegalArgumentException(NAME_TO_LONG.text());
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}