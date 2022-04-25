package racingcar.util;

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
        if(number < min) return false;
        return true;
    }
}
