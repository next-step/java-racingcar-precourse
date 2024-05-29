package util;

import exception.AttemptSizeException;
import exception.DuplicatedNameException;
import exception.NameLengthException;
import java.util.List;

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
        try {
            if (num < 1) {
                throw new AttemptSizeException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean checkNameLength(List<String> names) {
        try {
            for (String name : names) {
                if (name.length() > 5) {
                    throw new NameLengthException();
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean checkDuplicatedName(List<String> names) {
        long count = names.stream().distinct().count();

        try {
            if (count != names.size()) {
                throw new DuplicatedNameException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
