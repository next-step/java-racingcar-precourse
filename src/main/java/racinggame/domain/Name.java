package racinggame.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private String value;

    public Name(String value) {
        if (value == null || value.isEmpty() || value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5글자 이상 또는 비어있는 이름으로 자동차를 생성할 수 없습니다.");
        }

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
            return false;
        }
        Name name = (Name)o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
