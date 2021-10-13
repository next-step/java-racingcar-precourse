package racinggame.domain;

import java.util.Objects;

public class Name {

    private static final String ERROR_INVALID_NAME = "[ERROR] 자동차에 올바르지 않은 이름을 부여할 수 없습니다.";
    private static final String ERROR_NAME_TOO_LONG = "[ERROR] 자동차 이름은 최대 5자까지 입력할 수 있습니다.";

    private final String value;

    public Name(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if (Objects.isNull(value) || value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INVALID_NAME);
        }

        if (value.length() > 5) {
            throw new IllegalArgumentException(ERROR_NAME_TOO_LONG);
        }
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
