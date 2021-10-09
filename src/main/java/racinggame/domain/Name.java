package racinggame.domain;

import java.util.Objects;

public class Name {

    private String name;

    private Name(final String name) {
        this.name = name;
    }

    public static Name of(final String name) {
        return new Name(name);
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
