package racinggame.domain;

import racinggame.config.ErrorMessage;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_CAR_NAME_LENGTH.getValue());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
