package racingcar.domain;

import java.util.Objects;
import racingcar.util.Constants;

public class CarName {

    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    public String getValue() {
        return name;
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

    public static void validate(String name) {
        if (name.length() > Constants.NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("5글자 이내로 이름을 생성할 수 있습니다.");
        }
    }
}
