package racingcar.common;

public class ValidUtils {

    private ValidUtils() {
    }

    public static boolean stringEmptyValid(String target) {
        return target.isEmpty();
    }

    public static boolean stringGreaterThenMaxLength(String target, int maxLength) {
        return target.length() > maxLength;
    }

    public static boolean stringIsNotDigit(String target) {

        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }

    public static boolean integerLessThenMinNumber(int target, int minNumber) {
        return target < minNumber;
    }
}
