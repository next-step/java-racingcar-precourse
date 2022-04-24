package racingcar.util;

public class StringUtils {
    public static boolean isNumber(String numberString) {
        try {
            Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
