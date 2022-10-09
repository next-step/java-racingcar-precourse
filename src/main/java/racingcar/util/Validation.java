package racingcar.util;

/**
 * @author: Minwoo Kim
 * @date 2022/10/09
 */
public class Validation {

    private static final int MAXIMUM_LENGTH = 5;

    public static void checkName(String value) {
        if (value == null || value.length() > MAXIMUM_LENGTH || value.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkRetryCount(String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(value) < 0) {
            throw new IllegalArgumentException();
        }
    }
}
