package domain;

import java.util.Objects;

import static view.MessageConstant.EXCEED_CAR_NAME_ERROR;

public class CarName {
    String name;

    public CarName(String name) {
        if (!ValidationUtils.validateCarNameLength(name)) {
            throw new IllegalArgumentException(EXCEED_CAR_NAME_ERROR);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
