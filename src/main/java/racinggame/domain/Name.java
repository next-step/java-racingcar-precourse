package racinggame.domain;


import java.util.NoSuchElementException;
import java.util.Objects;

public class Name {

    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    private Name(final String name) {
        checkNameLength(name);
        this.name = name;
    }

    public static Name of(final Name name) {
        return new Name(name.name);
    }

    public static Name of(final String name) {
        return new Name(name);
    }

    private void checkNameLength(final String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new NoSuchElementException("이름은 다섯 글자를 넘을 수 없습니다.");
        }
    }

    public String value() {
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
