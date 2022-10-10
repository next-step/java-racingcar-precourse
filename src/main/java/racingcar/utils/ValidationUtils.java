package racingcar.utils;

import java.util.Objects;

public class ValidationUtils {
    private ValidationUtils() {
    }

    public static void requireNotNull(Object object, String errorMessage) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
