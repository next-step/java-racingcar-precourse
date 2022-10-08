package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateWhiteSpace(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateWhiteSpace(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 공백일 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하여야 합니다.");
        }
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
        return name;
    }
}
