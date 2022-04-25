package racingcar.validator;

import racingcar.constants.ErrorMessage;
import racingcar.domain.wrap.CarName;
import racingcar.utils.CarNamesUtils;

import java.util.HashSet;
import java.util.Set;

import static racingcar.constants.ErrorMessage.INVALID_CAR_COUNT_MESSAGE;
import static racingcar.constants.ErrorMessage.INVALID_SEPARATOR_MESSAGE;
import static racingcar.utils.CarNamesUtils.SEPARATOR;

/**
 * @author : choi-ys
 * @date : 2022-04-25 오전 1:20
 */
public class CarNamesValidator {
    public static final int MINIMUM_CAR_COUNT = 2;

    public static boolean isValidCarNames(String namesByComma) {
        return isValidSeparator(namesByComma) &&
                isValidCarCount(CarNamesUtils.splitByComma(namesByComma)) &&
                isAllValidCarNameLength(CarNamesUtils.splitByComma(namesByComma));
    }

    private static boolean isValidSeparator(String namesByComma) {
        try {
            isCommaSeparator(namesByComma);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INVALID_SEPARATOR_MESSAGE);
            return false;
        }
    }

    private static void isCommaSeparator(String namesByComma) {
        if (!namesByComma.contains(SEPARATOR)) {
            throw new IllegalArgumentException(INVALID_SEPARATOR_MESSAGE);
        }
    }

    private static boolean isValidCarCount(String[] namesArray) {
        try {
            isMinimumCarCount(namesArray);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INVALID_CAR_COUNT_MESSAGE);
            return false;
        }
    }

    private static void isMinimumCarCount(String[] namesArray) {
        if (!(namesArray.length >= MINIMUM_CAR_COUNT)) {
            throw new IllegalArgumentException(INVALID_CAR_COUNT_MESSAGE);
        }
    }

    private static boolean isAllValidCarNameLength(String[] namesArray) {
        Set<Boolean> isAllValid = new HashSet<>();
        for (String carName : namesArray) {
            isAllValid.add(isValidCarName(carName));
        }
        return !isAllValid.contains(false);
    }

    private static Boolean isValidCarName(String name) {
        try {
            new CarName(name);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INVALID_CAR_NAME_LENGTH_MESSAGE);
            return false;
        }
    }
}
