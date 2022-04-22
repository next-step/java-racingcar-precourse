package racingcar.domain;

import racingcar.constant.Conditions;
import racingcar.constant.ExceptionMessage;

public class Name {
    private String value;

    private Name(String value) {
        this.value = value;
    }

    public static Name from(String value) {
        validateValueSize(value);
        return new Name(value);
    }

    private static void validateValueSize(String value) {
        if (isEmpty(value)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_IS_NOT_EMPTY);
        }
        if (value.length() > Conditions.NAME_MAX_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_IS_DONT_OVER_SIZE);
        }
    }

    private static boolean isEmpty(String value) {
        return value == null || value.length() == 0;
    }

    public String getValue() {
        return this.value;
    }
}
