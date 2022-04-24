package racingcar.service;

import java.util.regex.Pattern;
import racingcar.domain.ErrorMessage;

public class InputValidator {

    private static final Pattern CAR_NAMES_INPUT_NOT_ALLOWED_CHARACTER = Pattern.compile("[^a-zA-Z0-9,]");

    public static void validateCarNamesInput(final String carNamesInput) {
        if (CAR_NAMES_INPUT_NOT_ALLOWED_CHARACTER.matcher(carNamesInput).find()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAMES_INPUT_HAS_NOT_ALLOWED_CHARACTER.getMessage());
        }
    }

    public static int validateTryCountInput(final String tryCountInput) {
        try {
            return Integer.parseInt(tryCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_NOT_A_NUMBER.getMessage());
        }
    }

}
