package racingcar;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Energy implements Comparable<Energy> {
    final int value;

    public Energy(final int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Energy energy = (Energy) o;
        return value == energy.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Energy target) {
        if (Objects.isNull(target)) {
            throw new IllegalArgumentException("[ERROR] target is null");
        }
        return target.compareBy(this.value);
    }

    private int compareBy(int source) {
        return source - this.value;
    }

}
