package racingcar.util;

import java.util.List;
import racingcar.message.ERRORMessage;

public class ValidateUtil {

    public static void validateNames(List<String> carNames) {
        for (String carName : carNames) {
            validate(carName);
        }
    }

    public static void validate(String inputText) {
        underFiveCharacter(inputText);
        blank(inputText);
    }

    private static void underFiveCharacter(String inputText) {
        if (inputText.length() > 5) {
            throw new IllegalArgumentException(ERRORMessage.CAR_NAME_VALIDATE_FIVE_CHARACTER);
        }
    }

    private static void blank(String inputText) {
        if (inputText.isEmpty()) {
            throw new IllegalArgumentException(ERRORMessage.CAR_NAME_VALIDATE_BLANK);
        }
    }

    public static void numberFormat(String inputText) {
        try {
            Integer.parseInt(inputText);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ERRORMessage.LAP_VALIDATE_INTEGER);
        }
    }

    public static void positive(Integer inputValue) {
        if (inputValue < 0) {
            throw new IllegalArgumentException(ERRORMessage.LAP_VALIDATE_POSITIVE);
        }
    }
}
