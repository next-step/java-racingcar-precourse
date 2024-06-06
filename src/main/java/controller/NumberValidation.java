package controller;

public class NumberValidation {

    private static final int MAX_NUMBER = 10;

    public static boolean isDigit(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
