package racingcar.utils;

import racingcar.cars.Cars;

import java.util.regex.Pattern;

public class ValidationUtils {

    public static final int CAR_NAME_LENGTH_LIMIT = 5;
    private static final Pattern ONLY_NUMBER = Pattern.compile("^[0-9]+$");

    public static boolean validateCarName(final String name, final int limit) {
        return name != null && !name.isEmpty() && !name.trim().isEmpty() && name.length() <= limit;
    }

    public static boolean isNumeric(final String input) {
        if (input == null || input.isEmpty() || input.trim().isEmpty()) {
            return false;
        }
        return ONLY_NUMBER.matcher(input).matches();
    }

    public static boolean validateSeparator(final String input) {
        return input != null && !input.trim().isEmpty() && !input.contains(Cars.CAR_NAME_SEPARATOR + Cars.CAR_NAME_SEPARATOR);
    }
}
