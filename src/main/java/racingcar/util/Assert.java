package racingcar.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Assert {

    private Assert() {
    }

    public static void notNull(final Object object, final String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(final Collection<?> collection, final String message) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notLessThan(final int target, final int reference, final String message) {
        if (target < reference) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notMoreThan(final int target, final int reference, final String message) {
        if (target > reference) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notDuplicated(final List<?> list, final String message) {
        final Set<?> set = new HashSet<>(list);
        if (list.size() != set.size()) {
            throw new IllegalArgumentException(message);
        }
    }
}
