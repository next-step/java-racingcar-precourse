package racingcar.domain.car;

import racingcar.constant.CarNameCondition;
import racingcar.constant.ExceptionMessage;

public class CarName {
    private String value;

    private CarName(String value) {
        this.value = value;
    }

    public static CarName from(String value) {
        validate(value);

        return new CarName(value);
    }

    private static void validate(String value) {
        checkIsEmpty(value);
        checkLength(value);
    }

    private static void checkIsEmpty(String value) {
        if (value == null || value.length() == 0) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_CANNOT_BE_EMPTY);
        }
    }

    private static void checkLength(String value) {
        if (value.length() > CarNameCondition.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_LENGTH_INVALID);
        }
    }

    public String getValue() {
        return this.value;
    }
}
