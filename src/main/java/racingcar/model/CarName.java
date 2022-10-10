package racingcar.model;

import racingcar.common.Messages;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public static CarName generate(String name) {
        validate(name);
        return new CarName(name);
    }

    public String get() {
        return name;
    }

    private CarName(String name) {
        this.name = name;
    }

    private static void validate(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(Messages.ERROR_EMPTY_CAR_NAME.toString());
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Messages.ERROR_LENGTH_CAR_NAME.toString());
        }
    }
}
