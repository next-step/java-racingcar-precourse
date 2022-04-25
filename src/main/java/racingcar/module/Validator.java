package racingcar.module;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static boolean validateRacingCarNames(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("input is not empty or null");
        }

        List<String> nameList = new ArrayList<>();
        for (String name : input.split(",", -1)) {
            if (name == null || name.trim().length() == 0 || name.length() >= 6 || nameList.contains(name)) {
                throw new IllegalArgumentException("invalid input name : " + name);
            }
            nameList.add(name);
        }

        return true;
    }

    public static boolean validateRacingCount(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("input is not empty or null");
        }

        try {
            if (isZeroOrNegative(Integer.parseInt(input))) {
                throw new IllegalArgumentException("input must be positive value");
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 한다.");
        }
    }

    private static boolean isEmpty(String input) {
        return input == null || input.trim().length() == 0;
    }

    private static boolean isZeroOrNegative(int value) {
        return value <= 0;
    }
}
