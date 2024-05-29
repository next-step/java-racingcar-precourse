package util;

import exception.AttemptSizeException;

public class InputValidator {

    public static boolean checkValidAttempt(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean checkAttemptSize(int num) {
        if (num < 1) {
            try {
                throw new AttemptSizeException();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }
}
