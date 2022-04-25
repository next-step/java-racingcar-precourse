package racingcar.domain;

import racingcar.constant.ConstantMessage;
import racingcar.constant.ConstantNumber;

public class CarValidation {

    public static boolean validateCarName(String input) {
        if (includedBlankAndSpace(input)) return false;
        if (includedComma(input)) return false;
        if (leastParticipateCar(input.split(ConstantMessage.COMMA))) return false;
        if (checkName(input.split(ConstantMessage.COMMA))) return false;
        return true;
    }

    private static boolean checkName(String[] names) {
        for (String name : names) {
            validName(name);
        }
        return false;
    }

    private static boolean validName(String name) {
        if (!isValidLengthName(name)) {
            throw new IllegalArgumentException(ConstantMessage.IS_NOT_VALID_CAR_LENGTH);
        }
        if (!includedBlank(name)) {
            throw new IllegalArgumentException(ConstantMessage.IS_NOT_VALID_CAR_LENGTH);
        }
        return false;
    }

    private static boolean includedBlank(String name) {
        return name.length() == name.trim().length();
    }

    private static boolean isValidLengthName(String name) {
        return name.length() >= ConstantNumber.MINIMUN_NAME_LENGTH && name.length() <= ConstantNumber.MAXIMUN_NAME_LENGTH;
    }

    private static boolean leastParticipateCar(String[] splitInput) {
        if (splitInput.length < ConstantNumber.CAN_PARTICIPATE_CAR) {
            throw new IllegalArgumentException(ConstantMessage.CAN_PARTICIPATE_CAR);
        }
        return false;
    }

    private static boolean includedComma(String input) {
        if (!input.contains(ConstantMessage.COMMA)) {
            throw new IllegalArgumentException(ConstantMessage.SPLIT_CAR_NAME_BY_COMMA);
        }
        return false;
    }

    private static boolean includedBlankAndSpace(String input) {
        if ("".equals(input) || " ".equals(input)) {
            throw new IllegalArgumentException(ConstantMessage.PLEASE_INPUT_RIGHT_CAR_NAME);
        }
        return false;
    }
}
