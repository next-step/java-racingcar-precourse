package racingcar.util;

public class ValidationUtil {

    static String PREFIX = "[ERROR] ";

    public static void validation(boolean validation, String message) {
        if (!validation) {
            String errorMessage = errorMessage(message);
            System.out.println(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static String errorMessage(String message) {
        return PREFIX + message;
    }
}
