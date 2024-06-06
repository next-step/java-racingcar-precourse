package controller;

import java.util.regex.Pattern;

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
}
