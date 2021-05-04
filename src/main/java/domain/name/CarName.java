package domain.name;

import java.util.Objects;

public class CarName {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private String name;

    public CarName(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차의 이름은 %d글자를 넘어서는 안됩니다.", CAR_NAME_MAX_LENGTH));
        }

        this.name = name;
    }

    @Override
    public boolean equals(Object dest) {
        if (this == dest) {
            return true;
        }
        if (dest == null || getClass() != dest.getClass()) {
            return false;
        }

        CarName carName = (CarName) dest;
        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
