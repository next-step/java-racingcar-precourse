package racingcar.domain;

import java.util.Objects;

public class Winner {

    private final Name name;

    public Winner(String name) {
        this.name = new Name(name);
    }

    public Winner(Name name) {
        this.name = name;
    }

    public String name() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner winner = (Winner) o;
        return Objects.equals(name, winner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
