package racingcar.domain;

import java.util.Objects;

public class CarName {
    private final String name;
    private static final int MAX_NAME_LENGTH = 5;

    public CarName(String name) {
        validNameLength(name);
        this.name = name.trim();
    }

    private void validNameLength(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("차의 이름은 공백이 될 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("차의 이름은 5이하 이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (target == null || getClass() != target.getClass()) {
            return false;
        }
        CarName carName = (CarName) target;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
