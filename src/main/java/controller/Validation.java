package controller;

import java.util.regex.Pattern;
import java.util.Set;
import java.util.HashSet;


public class Validation {

    public static boolean checkCarNames(String[] carNames) {
        if (!CarNamesValidation.isWithinMax(carNames) ||
            CarNamesValidation.isDuplication(carNames)) {
            return false;
        }
        for (String carName : carNames) {
            if (!CarNamesValidation.isEnglish(carName) ||
                !CarNamesValidation.isWithin5Chars(carName)) {
                return false;
            }
        }
        return true;
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
        Set<String> set = new HashSet<>();

        for (String element : carNames) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }

    static boolean isWithinMax(String[] carNames) {
        if (carNames.length <= MAX_NUMBER_OF_CAR_NAMES) {
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

    static boolean isWithinMax(String number) {
        if (Integer.parseInt(number) <= MAX_NUMBER) {
            return true;
        }
        return false;
    }
}
