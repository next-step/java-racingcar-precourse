package racingcar.application;

import static java.lang.String.format;
import static racingcar.domain.ErrorMessage.*;
import static racingcar.presentation.CarViewConstants.CAR_NAME_SPLITTER;

public class ValidService {

    public static void validCarsNameAnswer(String carNameAnswer) {
        String lastString = Character.toString(carNameAnswer.charAt(carNameAnswer.length() - 1));
        if (CAR_NAME_SPLITTER.equals(lastString)) {
            throw new IllegalArgumentException(format(CARS_NAME_SPLITTER, CAR_NAME_SPLITTER));
        }
    }

    public static void validRoundNumberAnswer(String roundNumberAnswer) {
        validInteger(roundNumberAnswer);
        validNumberRange(roundNumberAnswer);
    }

    private static void validInteger(String roundNumberAnswer) {
        try {
            Integer.parseInt(roundNumberAnswer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ROUND_ONLY_NUMBER);
        }
    }

    private static void validNumberRange(String roundNumberAnswer) {
        if (Integer.parseInt(roundNumberAnswer) <= 0) {
            throw new IllegalArgumentException(ROUND_NUMBER_OVER_ONE);
        }
    }
}
