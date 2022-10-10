package racingcar.domain;

import java.util.Objects;

public class Location {
    private final int location;

    public Location() {
        this.location = 0;
    }

    public Location(int location) {
        this.location = location;
    }

    public Location add() {
        return new Location(location + 1);
    }

    public boolean isGreaterOrEqual(Location location) {
        return this.location >= location.location;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location1 = (Location) o;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
