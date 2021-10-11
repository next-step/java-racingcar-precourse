package racinggame.domain;

import racinggame.message.ErrorMessage;

import java.util.Objects;

public class CarName {
    public static final int MAX_LENGTH = 5;
    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }
    
    private static void validate(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.OUT_OF_NAME_LENGTH_ERROR.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(getName(), carName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
