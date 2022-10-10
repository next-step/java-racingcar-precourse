package racingcar.domain;

import java.util.Objects;

public class CarName {

    public static final int CAR_NAME_MAX_SIZE = 5;
    private final String name;

    public CarName(String name) {
        if (isNotValidName(name)) {
            throw new IllegalArgumentException("차 이름을 5자 이하로 입력해 주세요.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isNotValidName(String name) {
        return name.length() == 0 || name.length() > CAR_NAME_MAX_SIZE;
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
}
