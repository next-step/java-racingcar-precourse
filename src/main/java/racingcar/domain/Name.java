package racingcar.domain;

import racingcar.util.ExceptionMessageUtil;

import java.util.Objects;

public class Name {

    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름의 길이는 1~5자 입니다.";
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1;

    private final String value;

    private Name(String value) {
        if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessageUtil.errorMessage(NAME_LENGTH_EXCEPTION_MESSAGE));
        }
        this.value = value;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(value, name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}