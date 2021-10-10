package nextstep.domain;

import java.util.Objects;

public class RaceResult {

    private final String names;

    public RaceResult(String names) {
        this.names = names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceResult result = (RaceResult) o;
        return Objects.equals(names, result.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
