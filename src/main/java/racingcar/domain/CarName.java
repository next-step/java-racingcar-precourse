package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final String INVALID_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하여야 한다. (공백 불가)";
    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    CarName(String name) {
        if (isInvalidName(name)) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR_MESSAGE);
        }

        this.value = name;
    }

    String value() {
        return this.value;
    }

    private boolean isInvalidName(String name) {
        return Objects.isNull(name) || name.isEmpty() || name.length() > MAX_NAME_LENGTH;
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
        return value != null ? value.hashCode() : 0;
    }
}
