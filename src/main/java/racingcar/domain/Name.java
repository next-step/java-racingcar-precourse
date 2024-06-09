package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    public Name(final String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public String value() {
        return this.name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
