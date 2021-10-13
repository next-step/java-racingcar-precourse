package racinggame.domain;

import racinggame.utils.ValidationUtils;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        if (name == null || name.trim().equals(""))
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        if (!ValidationUtils.validateCarNameLength(name))
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로 입력해주세요.");
        this.name = name;
    }

    public String getName() {
        return name;
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
