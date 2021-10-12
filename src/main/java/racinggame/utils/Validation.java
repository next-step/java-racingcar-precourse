package racinggame.utils;

import static nextstep.utils.Randoms.pickNumberInRange;

public class Validation {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final String CAR_NAME_DIVISION = ",";
    private static final int MIN_RUN_NUMBER = 1;
    private static final int MIN_CHECK_RUN_NUMBER = 0;
    private static final int MAX_CHECK_RUN_NUMBER = 9;
    private static final int RUN_NUMBER = 4;

    public static Boolean validateCarNameLength(String carName) {
        if(matchCarNameLength(carName))
            return true;
        return false;
    }

    public static Boolean matchCarNameLength(String carName) {
        return carName.length() >= MIN_CAR_NAME_LENGTH && carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    public static String[] DivideCarNames(String carNames) {
        return carNames.split(CAR_NAME_DIVISION);
    }

    public static Boolean validateRunNumber(String runNumber) {
        if(!isNumeric(runNumber))
            return false;
        if(!isOverZero(runNumber))
            return false;
        return true;
    }

    public static Boolean isOverZero(String runNumber) {
        return Integer.parseInt(runNumber) >= MIN_RUN_NUMBER;
    }

    public static Boolean isNumeric(String number) {
        return number.matches("[+-]?\\d*(\\.\\d+)?");
    }

    public static Boolean checkRunCar() {
        if(pickNumberInRange(MIN_CHECK_RUN_NUMBER, MAX_CHECK_RUN_NUMBER) >= RUN_NUMBER)
            return true;
        return false;
    }
}

