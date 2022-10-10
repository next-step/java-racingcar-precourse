package racingcar.domain;

import java.util.Objects;
import racingcar.message.ErrorMessage;

public class CarName {
    public static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        if (isNotValidName(name)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_CAR_NAMES);
        }
        this.name = name;
    }

    private boolean isNotValidName(String name) {
        return (name.isEmpty() || name.length() > NAME_MAX_LENGTH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
