package racingcar.util;

import java.util.Collection;

public class ValidationUtils {
    public static boolean validNumberOfLetter(String letter, int minNumber, int maxNumber) {
        if (letter == null) return false;

        int letterLength = letter.length();
        if (letterLength < minNumber || letterLength > maxNumber) {
            return false;
        }
        return true;
    }

    public static boolean validNumberMinimum(int number, int min) {
        if (number < min) return false;
        return true;
    }

    public static <T> boolean isEmpty(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) return false;
        return true;
    }
}
