package racingcar.domain;

import racingcar.common.ErrorMessage;

public class CarName {

    private final String name;
    private static final int MAX_SIZE = 5;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_NAME_EMPTY);
        }
        if (checkMaxSize(name)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_NAME_OVER_SIZE);
        }
    }

    private boolean isEmpty(String name) {
        return name == null || name.trim().length() == 0;
    }

    private boolean checkMaxSize(String name) {
        return name.length() > MAX_SIZE;
    }

    public String getName() {
        return this.name;
    }
}
