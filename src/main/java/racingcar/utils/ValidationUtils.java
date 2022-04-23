package racingcar.utils;

import java.util.Objects;

public final class ValidationUtils {

    private static final String EMPTY = "";

    private ValidationUtils() {
        throw new ClassCastException();
    }

    public static void validConditionThrowIfTrue(boolean condition, String message) {
        if (condition) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validObjectThrowIfNull(Object object, String message) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validStringThrowIfEmpty(String string, String message) {
        if (Objects.isNull(string) || EMPTY.equals(string)) {
            throw new IllegalArgumentException(message);
        }
    }

}
