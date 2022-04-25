package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListUtils {

    private ListUtils() {
    }

    public static <T, R> List<R> map(final List<T> source, final Function<T, R> mapper) {
        final List<R> result = new ArrayList<>();
        for (T element : source) {
            result.add(mapper.apply(element));
        }
        return result;
    }

    public static <T> List<T> filter(final List<T> source, final Predicate<T> predicate) {
        final List<T> result = new ArrayList<>();
        for (T element : source) {
            addToResultIfTrue(element, result, predicate);
        }
        return result;
    }

    private static <T> void addToResultIfTrue(final T element, final List<T> result, final Predicate<T> predicate) {
        if (predicate.test(element)) {
            result.add(element);
        }
    }
}
