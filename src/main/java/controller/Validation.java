package controller;

import java.util.regex.Pattern;
import java.util.HashSet;

public class Validation {

    public static void checkCarNames(String[] carNames) {
        if (!CarNamesValidation.isWithinRange(carNames) ||
            CarNamesValidation.isDuplication(carNames)) {
            throw new IllegalArgumentException();
        }
        for (String carName : carNames) {
            if (!CarNamesValidation.isEnglish(carName) ||
                !CarNamesValidation.isWithin5Chars(carName)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkNumber(String number) {
        if (!NumberValidation.isDigit(number) || !NumberValidation.isWithinRange(number)) {
            throw new IllegalArgumentException();
        }
    }
}

class CarNamesValidation {

    private static final int MAX_NUMBER_OF_CAR_NAMES = 5;

    static boolean isWithin5Chars(String carName) {
        if (carName.length() <= 5) {
            return true;
        }
        return false;
    }

    static boolean isEnglish(String carName) {
        return Pattern.matches("^[a-zA-Z]*$", carName);
    }

    static boolean isDuplication(String[] carNames) {
        HashSet<String> set = new HashSet<>();

        for (String element : carNames) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }

    static boolean isWithinRange(String[] carNames) {
        if (carNames.length > 0 && carNames.length <= MAX_NUMBER_OF_CAR_NAMES) {
            return true;
        }
        return false;
    }
}

class NumberValidation {

    private static final int MAX_NUMBER = 10;

    static boolean isDigit(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    static boolean isWithinRange(String number) {
        if (Integer.parseInt(number) > 0 && Integer.parseInt(number) <= MAX_NUMBER) {
            return true;
        }
        return false;
    }
}
