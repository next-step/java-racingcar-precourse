package racingcar.domain.car;

import static racingcar.utils.ValidationUtils.requireNotNull;

import java.util.Objects;

public class Distance {
    public static Distance ZERO = new Distance(0);

    private final int value;

    public Distance(int value) {
        this.value = value;
    }

    public int toInt() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Distance plus(Distance other) {
        requireNotNull(other, "Other distance must not be null!");
        return new Distance(this.value + other.value);
    }
}
