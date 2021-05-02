package domain;

import java.util.Objects;

public class Count {
    private int value;

    public static Count minusOne() {
        return new Count(-1);
    }

    public static Count zero() {
        return new Count(0);
    }

    public Count(int value) {
        this.value = value;
    }

    public Count add(Count count) {
        return new Count(this.value + count.getValue());
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Count)) return false;
        Count count1 = (Count) o;
        return value == count1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
