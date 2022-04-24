package racingcar.validator;

import racingcar.utils.MessageUtil;

public class Validator {

    private static final int VALIDATOR_NAME_SIZE = 5;

    private Validator() {
    }

    public static void validatorRound(String round) {
        validateEmpty(round);
        validateNumber(round);
    }

    public static void validateNumber(String value) {
        boolean isNumeric =  value.matches("[+-]?\\d*(\\.\\d+)?");

        if (!isNumeric) {
            throw new IllegalArgumentException(MessageUtil.VALIDATE_NUMBER_MESSAGE);
        }
    }

    public static void validatorNames(String[] inputNames) {
        validatorNamesEmpty(inputNames);
        validatorNamesLength(inputNames);

    }

    public static void validatorNamesEmpty(String[] inputNames) {
        if (inputNames == null || inputNames[0].equals("")) {
            throw new IllegalArgumentException(MessageUtil.VALIDATOR_NAMES_MESSAGE);
        }
    }

    public static void validatorNamesLength(String[] inputNames) {
        for (String inputName : inputNames) {
            validatorNameLength(inputName);
        }
    }

    public static void validatorNameLength(String inputName) {
        if (inputName.length() > VALIDATOR_NAME_SIZE) {
            throw new IllegalArgumentException(MessageUtil.VALIDATOR_EXCEEDED_NAMES_MESSAGE);
        }
    }

    public static void validateEmpty(String value) {
        if (value == null || value.equals("")) {
            throw new IllegalArgumentException(MessageUtil.VALIDATE_EMPTY_MESSAGE);
        }
    }

}
