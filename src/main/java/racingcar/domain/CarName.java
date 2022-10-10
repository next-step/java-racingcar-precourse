package racingcar.domain;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacinggameException;

public class CarName {
    private static final int CAR_NAME_SIZE = 5;

    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName from(String name) {
        validateCarName(name);

        return new CarName(name);
    }

    private static void validateCarName(String name) {
        if (name == null) {
            throw new RacinggameException(ErrorMessage.INVALID_CAR_NAME_NULL.getValue());
        }

        if (name.length() > CAR_NAME_SIZE) {
            throw new RacinggameException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getValue());
        }

        if (name.isEmpty()) {
            throw new RacinggameException(ErrorMessage.INVALID_CAR_NAME_EMPTY.getValue());
        }
    }

    public String getName() {
        return this.name;
    }
}
