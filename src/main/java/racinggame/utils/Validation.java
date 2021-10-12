package racinggame.utils;

public class Validation {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final String CAR_NAME_DIVISION = ",";

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
}

