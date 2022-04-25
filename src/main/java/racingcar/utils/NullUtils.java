package racingcar.utils;

public class NullUtils {

    public static void validNull(Object obj, RuntimeException re) {
        if (obj == null) {
            throw re;
        }
    }

    public static void validNullArgument(Object obj, String message) {
        NullUtils.validNull(obj, new IllegalArgumentException("[ERROR] " + message));
    }
}
