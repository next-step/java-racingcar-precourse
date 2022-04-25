package racingcar.util;

import java.util.Collection;

public class ValidationUtils {
    public static boolean validNumberOfLetter(String letter, int minNumber, int maxNumber) {
        if (letter == null) return false;

        int letterLength = letter.length();
        return letterLength >= minNumber && letterLength <= maxNumber;
    }

    public static boolean validNumberMinimum(int number, int min) {
        return min <= number;
    }

    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection != null && !collection.isEmpty();
    }
}
