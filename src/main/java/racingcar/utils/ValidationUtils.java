package racingcar.utils;

import static racingcar.constant.ErrorMessages.*;
import static racingcar.constant.GameConfig.NAME_LENGTH;
import static racingcar.constant.GameConfig.NAME_SEPARATOR;

public class ValidationUtils {

    public static String[] nameValidation(final String names) {
        nameNullCheck(names);
        String[] splitName = nameSplit(names);
        namesCheck(splitName);
        return splitName;
    }

    public static Integer roundValidation(final String round) {
        roundNullCheck(round);
        Integer roundNumber = integerRound(round);
        checkGreaterThanZero(roundNumber);
        return roundNumber;
    }

    private static void checkGreaterThanZero(final Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ROUND_LESS_THEN_ZERO);
        }
    }

    private static Integer integerRound(final String round) {
        try {
            return Integer.valueOf(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ROUND_NOT_NUMBER);
        }
    }

    private static void roundNullCheck(final String round) {
        if (round.isEmpty()) {
            throw new IllegalArgumentException(ROUND_NOT_INPUT);
        }
    }

    private static void nameNullCheck(final String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(NAME_NOT_INPUT);
        }
    }

    private static void namesCheck(final String[] names) {
        for (String name : names) {
            nameLengthCheck(name, NAME_LENGTH);
        }
    }

    private static void nameLengthCheck(final String name, final int size) {
        if (name.length() < 1 || name.length() >  size){
            throw new IllegalArgumentException(NAME_LENGTH_EXCEEDED);
        }
    }

    private static String[] nameSplit(final String names) {
        return names.split(NAME_SEPARATOR);
    }

}
