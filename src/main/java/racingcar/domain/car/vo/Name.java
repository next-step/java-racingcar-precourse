package racingcar.domain.car.vo;

import java.util.Objects;

public final class Name {

    private final String value;

    public Name(String value) {
        value = value.trim();
        validationBlank(value);
        validationRange(value);

        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void validationBlank(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 이름은 공백일 수 없습니다.");
        }
    }

    private void validationRange(String value) {
        if (value.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하여야 합니다.");
        }
    }
}