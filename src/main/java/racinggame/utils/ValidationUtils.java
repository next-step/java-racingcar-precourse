package racinggame.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {
    private static final int CAR_NAME_MAX_LENGTH = 5;   // 자동차 이름 가능 최대글자수

    public static boolean validateCarNameLength(String name) {
        return !(name.length() > CAR_NAME_MAX_LENGTH);
    }

    public static boolean validateCarsNames(String names) {
        String[] arrNames = names.split(",");

        // 글자수 체크
        int max = 0;
        for (String name : arrNames) {
            max = Math.max(max, name.length());
        }
        return !(max > CAR_NAME_MAX_LENGTH);
    }

    public static boolean duplicateCarNames(String names) {
        String[] arrNames = names.split(",");
        Set<String> cars = new HashSet<>(Arrays.asList(arrNames));
        return arrNames.length != cars.size();
    }

    public static boolean validateTryNo(String tryNo) {
        int num;
        try {
            num = Integer.parseInt(tryNo);
        } catch (NumberFormatException e) {
            return false;
        }
        return isPositiveNumber(num);
    }

    public static boolean isPositiveNumber(int num) {
        return num > 0;
    }
}
