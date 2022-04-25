package racingcar.domain;

import java.util.Objects;

import static racingcar.view.ErrorMessage.DEFAULT;
import static racingcar.view.ErrorMessage.NAME_LESS_FIVE;

public class CarName {

    public static final int NAME_SIZE_LIMIT = 5;

    private final String name;

    public CarName(String name) {
        if (isNotCreate(name)) {
            throw new IllegalArgumentException(DEFAULT.getMessage() + NAME_LESS_FIVE.getMessage());
        }
        this.name = name;
    }

    private boolean isNotCreate(String name) {
        if (name == null) return true;

        name = name.trim();
        return name.isEmpty() || name.length() > NAME_SIZE_LIMIT;
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

    @Override
    public String toString() {
        return name;
    }
}
