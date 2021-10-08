package racinggame.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static boolean isNumberic(String str) {
        if (str == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean validateCarName(String str) {
        if (str.length() > MAX_CAR_NAME_LENGTH) {
            return false;
        }
        return true;
    }

    public static boolean enablePlayGame(String str) {
        String[] cars = str.split(",");
        int i = 0;
        int n = cars.length;
        if (hasDuplicatedCarNm(str, n)) {
            return false;
        }
        while (i < n - 1 && validateCarName(cars[i])) {
            i++;
        }
        return validateCarName(cars[i]);
    }

    public static boolean hasDuplicatedCarNm(String str, int n) {
        Set<String> set = new HashSet<>(Arrays.asList(str.split(",")));
        if (n != set.size()) {
            return true;
        }
        return false;
    }
}
