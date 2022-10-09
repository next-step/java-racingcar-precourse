package racingcar;

import static java.lang.Character.isDigit;
import static racingcar.PrintStrings.*;

public class ValidCheck {


    public static final int CAR_NAME_MAX_SIZE = 5;

    public static boolean SizeCheck(String inputName) {
        if (inputName.length() <= CAR_NAME_MAX_SIZE)
            return true;
        return false;
    }

    public static boolean inputNumberIsNUmber(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            if (!isDigit(inputNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void CheckInputNumber(String inputNumber) {
        if (!ValidCheck.inputNumberIsNUmber(inputNumber)) {
            throw new IllegalArgumentException(ERROR_CHECK_NUMBER_MESSAGE);
        }
    }


    public static void checkInputName(String carName) {
        if (!ValidCheck.SizeCheck(carName)) {
            throw new IllegalArgumentException(ERROR_CHECK_CAR_NAME_MESSAGE);
        }
    }

}
