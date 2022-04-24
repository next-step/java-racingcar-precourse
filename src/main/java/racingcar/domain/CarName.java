package racingcar.domain;

import java.util.Objects;

import static racingcar.domain.ErrorMessage.CAR_NAME_LENGTH_ERROR;

public class CarName {

    private static final int NAME_LENGTH_MAX = 5;

    private final String value;

    public CarName(String value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(String value) {
        if (value.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
