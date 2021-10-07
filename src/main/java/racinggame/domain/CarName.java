package racinggame.domain;

import racinggame.error.ValidationFailureException;
import racinggame.type.Messages;

import java.util.Objects;

public class CarName {

    private static final int NAME_MAX_LENGTH = 5;

    private final String value;

    private CarName(String value) {
        throwIfNameTooLongOrEmpty(value);
        this.value = value;
    }

    public void throwIfNameTooLongOrEmpty(String value) {
        if (Objects.isNull(value) || value.isEmpty() || value.length() > NAME_MAX_LENGTH) {
            throw new ValidationFailureException(Messages.ERROR_NAME_TOO_LONG_OR_EMPTY.getMessage());
        }
    }

    public static CarName from(String value) {
        return new CarName(value);
    }

    public String getValue() {
        return value;
    }
}
