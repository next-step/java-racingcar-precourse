package racinggame.domain;

import java.util.Objects;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    public String getValue() {
        return name;
    }

    public static void validate(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("5글자 이내로 이름을 생성할 수 있습니다.");
        }
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
