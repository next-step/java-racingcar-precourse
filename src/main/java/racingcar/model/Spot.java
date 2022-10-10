package racingcar.model;

import java.util.Objects;

import static racingcar.util.Scale.MOVE_INCREASE;
import static racingcar.util.Scale.MOVE_MIN;

public class Spot {
    private int at;

    public Spot(int at) {
        this.at = at;
    }

    public Spot() {
        this(MOVE_MIN);
    }

    public boolean isFartherThan(Spot candidate) {
        return this.at > candidate.at;
    }

    public boolean isAtIdenticalSpot(Spot maxSpot) {
        return this.at == maxSpot.at;
    }

    public Spot move() {
        return new Spot(this.at + MOVE_INCREASE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(at);
    }

    @Override
    public String toString() {
        return "Spot{" +
                "at=" + at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spot spot = (Spot) o;
        return at == spot.at;
    }

    public int at() {
        return this.at;
    }
}
