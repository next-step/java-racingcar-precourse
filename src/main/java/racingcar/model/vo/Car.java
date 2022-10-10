package racingcar.model.vo;

import racingcar.model.constants.ErrorMessage;

public class Car {

    private static final int NAME_LENGTH_LIMIT = 5;
    private final String carName;

    public Car(String name) throws IllegalArgumentException {
        if (!validateNameLength(name)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_PREFIX + ErrorMessage.CAR_NAME_LENGTH_LIMIT);
        }
        if (!validateNameNotEmpty(name)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_PREFIX + ErrorMessage.CAR_NAME_EMPTY);
        }
        this.carName = name;
    }

    protected static boolean validateNameLength(String name) {
        return name.length() <= NAME_LENGTH_LIMIT;
    }

    protected static boolean validateNameNotEmpty(String name) {
        if (name == null) {
            return false;
        }
        name = name.replaceAll(" ", "");
        return name.length() != 0;
    }

    public String getCarName() {
        return carName;
    }


}
