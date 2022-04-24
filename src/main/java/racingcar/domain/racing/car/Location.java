package racingcar.domain.racing.car;

import java.util.Objects;

public class Location {
    private final int value;

    public Location(int location) {
        this.value = location;
    }

    public static Location from(int location) {
        return new Location(location);
    }

    public Location add(int distance) {
        return new Location(value + distance);
    }

    int get() {
        return value;
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
        return value == location1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
