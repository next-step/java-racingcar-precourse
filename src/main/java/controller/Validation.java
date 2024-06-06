package controller;

public class Validation {

    public static boolean isWithin5Chars(String carName) {
        if (carName.length() <= 5) {
            return true;
        }
        return false;
    }
}
