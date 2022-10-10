package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        String refinedName = name.trim();
        if (StringUtils.isBlank(refinedName)) {
            throw new IllegalArgumentException("자동차 이름은 빈값이 될 수 없습니다.");
        }

        if (refinedName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.");
        }

        this.name = refinedName;
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
