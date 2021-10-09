package racinggame.domain;

import racinggame.domain.exceptions.InvalidNameLengthException;

import java.util.Objects;

public class Name {

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
        if (name.length() > 5) {
            throw new InvalidNameLengthException();
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
