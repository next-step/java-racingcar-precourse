package racinggame.domain;

import racinggame.error.ValidationFailureException;
import racinggame.type.Messages;

public class TryTimes {

    private static final int MIN_VALUE = 0;

    private final int value;

    public TryTimes(int value) {
        throwIfInvalidValue(value);
        this.value = value;
    }

    private void throwIfInvalidValue(int value) {
        if (value < MIN_VALUE) {
            throw new ValidationFailureException(Messages.ERROR_TRYTIMES_MUST_BE_GREATER_THAN_ZERO.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
