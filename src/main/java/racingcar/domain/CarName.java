package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CarName))
            return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private void validate(String name) {
        if (isInvalidFormat(name))
            throw new IllegalArgumentException("적절하지 않은 글자");

        if (isGreaterThanLimit(name)) {
            throw new IllegalArgumentException("글자수 제한 초과");
        }
    }

    private boolean isInvalidFormat(String name) {
        return name == null || name.isEmpty();
    }

    private boolean isGreaterThanLimit(String name) {
        return name.length() > MAX_CAR_NAME_LENGTH;
    }
}
