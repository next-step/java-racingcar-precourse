package racing;

import java.util.function.Function;

public class Comparison {
    public static <T> boolean Equals(T source, Object target, Function<T, Boolean> compare) {
        if (source == target)
            return true;

        if (target == null || source.getClass() != target.getClass())
            return false;

        return compare.apply((T) target);
    }
}
