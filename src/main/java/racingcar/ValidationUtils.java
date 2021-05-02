package racingcar;

public class ValidationUtils {
    public static boolean isValidName(String name) {
        if (name == null) return false;

        return (name.length() <= 5);
    }
}
