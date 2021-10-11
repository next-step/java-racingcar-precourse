package racinggame.car.utils;

import racinggame.Enum.Error;

public class CarsUtil {
    public static int CAR_MIN_LENGTH = 1;
    public static int CAR_MAX_LENGTH = 5;

    public static String[] makeCarStringToAry(String carsNameStr) {
        return carsNameStr.split("\\s*,\\s*");
    }

    public static boolean validationCarName(String carName) {
        return carName.length() >= CAR_MIN_LENGTH && carName.length() <= CAR_MAX_LENGTH;
    }

    public static String CarName(String inputName) {
        String inputTrimName = inputName.trim();
        if (!CarsUtil.validationCarName(inputTrimName)) {
            throw new IllegalArgumentException(Error.ERROR_MSG_CARNAME.getMsg());
        }
        return inputName;
    }

}
