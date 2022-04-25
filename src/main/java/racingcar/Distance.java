package racingcar;

import java.util.Objects;

public class Distance {
    private int value;

    public Distance() {
        this.value = 0;
    }

    public int toInt() {
        return value;
    }

    public void inc() {
        value++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < value; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
