package racinggame.domain;

import java.util.Objects;

import racinggame.exception.RacingGameErrorCode;
import racinggame.exception.RacingGameException;
import racinggame.utils.Message;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;

    private String value;

    public CarName(String value) {
        if (value == null || value.isEmpty() || value.length() > MAX_NAME_LENGTH) {
            throw new RacingGameException(RacingGameErrorCode.INVALID_CAR_NAME);
        }

        this.value = value;
    }

    public Message makeNameMessage() {
        return new Message(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarName)) {
            return false;
        }
        CarName carName = (CarName)o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
