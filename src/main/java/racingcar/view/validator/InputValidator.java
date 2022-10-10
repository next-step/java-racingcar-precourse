package racingcar.view.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racingcar.domain.constants.InputConst.NAME_LENGTH_MAX;

public class InputValidator {
    public static boolean isEmpty(String[] carNames) {
        return Arrays.stream(carNames).anyMatch(String::isEmpty);
    }

    public static boolean hasDuplicateValue(String[] carNames) {
        List<String> validCarNames = new ArrayList<String>();
        for(String carName : carNames) {
            if(validCarNames.contains(carName)) {
                return true;
            }
            validCarNames.add(carName);
        }
        return false;
    }

    public static boolean isInvalidLength(String[] carNames) {
        return Arrays.stream(carNames).anyMatch(carName -> carName.length() > NAME_LENGTH_MAX);
    }

    public static boolean isInteger(String tryNumber) {
        try {
            Integer.parseInt(tryNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isBiggerThanOne(int tryNumber) {
        return tryNumber >= 1;
    }
}
