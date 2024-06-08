package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.ErrorConstants;

public class InputValidator {

    private static final String COMMA_SEPARATED_REGEX = "^[^,]+(,[^,]+)*$\n";

    private static void inputIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorConstants.BLANK);
        }
    }

    private static int isInteger(String input) {
        inputIsBlank(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConstants.OVER_INTEGER);
        }
    }

    private static void isCommaSeparated(String input) {
        if (!input.matches(COMMA_SEPARATED_REGEX)) {
            throw new IllegalArgumentException(ErrorConstants.INADEQUATE_INPUT);
        }
    }

    public static List<String> validateCommaSeparatedStrings(String input) {
        isCommaSeparated(input);
        List<String> result = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        return result;
    }
}
