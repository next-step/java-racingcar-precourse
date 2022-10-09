package racingcar.domain;

import java.util.Objects;
import java.util.Optional;

public class Name {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    static final String INVALID_NAME_LENGTH_MESSAGE = String.format("자동차 이름은 %d ~ %d자 사이로 입력해주세요.",
                                                                    MIN_LENGTH, MAX_LENGTH);

    private final String value;

    private Name(String value) {
        this.value = value;
    }

    public static Name from(String value) {
        return new Name(validate(value));
    }

    //@formatter:off
    private static String validate(String value) {
        return Optional.ofNullable(value)
                .filter(s -> MIN_LENGTH <= s.length() && s.length() <= MAX_LENGTH)
                .orElseThrow(() -> new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE));
    }
    //@formatter:on

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

    @Override
    public String toString() {
        return value;
    }
}
