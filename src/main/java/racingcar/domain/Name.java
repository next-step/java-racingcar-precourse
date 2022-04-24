package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int MAXIMUM_RANGE_OF_NAME = 5;
    private static final String BLANK_ERROR_MSG = "이름을 입력해야합니다.";
    private static final String LENGTH_OVER_ERROR_MSG = "5자 이상을 입력할 수 없습니다.";

    private final String name;

    public Name(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(BLANK_ERROR_MSG);
        }

        if (name.length() > MAXIMUM_RANGE_OF_NAME) {
            throw new IllegalArgumentException(LENGTH_OVER_ERROR_MSG);
        }

        this.name = name;
    }

    public String value() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
