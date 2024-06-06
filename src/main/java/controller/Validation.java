package controller;

import java.util.regex.Pattern;
import java.util.Set;
import java.util.HashSet;

public class Validation {

    public static boolean isWithin5Chars(String carName) {
        if (carName.length() <= 5) {
            return true;
        }
        return false;
    }

    public static boolean isEnglish(String carName) {
        return Pattern.matches("^[a-zA-Z]*$", carName);
    }

    public static boolean isDuplication(String[] carNames) {
        Set<String> set = new HashSet<>();

        for (String element : carNames) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }
}
