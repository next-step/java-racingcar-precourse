package racingcar.game;

import racingcar.game.util.SingleValue;

import java.util.Objects;

public class Distance extends SingleValue<Integer> implements Comparable<Distance> {

    public Distance(int distance) {
        super(distance);
    }

    public Distance increased(int distance) {
        return new Distance(value + distance);
    }

    public Distance increased(Distance distance) {
        return increased(distance.value);
    }

    public boolean isGreaterThan(Distance another) {
        return compareTo(another) > 0;
    }

    public boolean isLessThan(Distance another) {
        return compareTo(another) < 0;
    }

    @Override
    public String toString() {
        return GameUtil.repeatString(value, "-");
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Distance) {
            return Objects.equals(value, ((Distance) o).get());
        }
        return false;
    }

    @Override
    public int compareTo(Distance another) {
        return Integer.compare(this.value, another.value);
    }
}
