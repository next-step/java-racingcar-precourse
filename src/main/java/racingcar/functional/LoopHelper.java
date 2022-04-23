package racingcar.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LoopHelper {

    private LoopHelper() {}

    public static <T> void listForEach(List<T> source, Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T value: source) {
            action.accept(value);
        }
    }

    public static <T, R> List<R> listMap(List<T> source, Function<? super T, ? extends R> mapper) {
        Objects.requireNonNull(mapper);

        List<R> result = new ArrayList<>();
        listForEach(source, (value) -> {
            result.add(mapper.apply(value));
        });

        return result;
    }

    public static <T> List<T> listFilter(List<T> source, Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);

        List<T> result = new ArrayList<>();
        listForEach(source, (value) -> {
            if (predicate.test(value)) {
                result.add(value);
            }
        });

        return result;
    }

    public static Integer maxValueInIntegerList(List<Integer> source) {
        if (source.isEmpty()) {
            throw new IllegalArgumentException("Empty list are not allowed.");
        }

        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        listForEach(source, (value) -> {
            max.set(Math.max(max.get(), value));
        });

        return max.get();
    }
}
