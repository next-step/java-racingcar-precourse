package racingcar.utils;

public class StringUtils {

    public static boolean isEmpty(String str) {
        if (str == null || str.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static void validEmptyStringArgument(String str, String message) {
        if (!StringUtils.isEmpty(str)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR]" + message);
    }
}
