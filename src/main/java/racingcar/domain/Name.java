package racingcar.domain;

import racingcar.util.Utils;

import java.util.Objects;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private static void validateName(String name) {
        if (name.isEmpty() || name.contains(" ")) {
            throw new IllegalArgumentException("이름에 빈 문자열이거나 공백이 있습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }
        if (!Utils.isAlphabet(name)) {
            throw new IllegalArgumentException("이름은 알파벳만 가능합니다.");
        }
    }

    public String getName() {
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
