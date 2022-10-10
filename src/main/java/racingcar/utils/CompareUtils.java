package racingcar.utils;

import java.util.List;
import java.util.regex.Pattern;

public class CompareUtils {
    private static final String REGEXP_POSITIVE_NUMBER = "^[1-9]\\d*$";

    private CompareUtils() {
    }

    public static int getLargestInteger(List<Integer> integerList) {
        int maxInt = 0;

        for (int i : integerList) {
            maxInt = getBiggerInt(i, maxInt);
        }

        return maxInt;
    }

    private static int getBiggerInt(int value1, int value2) {
        if (value1 > value2) {
            return value1;
        }

        return value2;
    }

    public static boolean isPositiveInteger(String stringNum) {
        if (stringNum == null) {
            return false;
        }
        return Pattern.compile(REGEXP_POSITIVE_NUMBER).matcher(stringNum).matches();
    }
}
