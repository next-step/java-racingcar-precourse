package utils;

import racingcar.constant.NumberConst;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {
    public static boolean validateCarName(String name) {
        return name.length() <= NumberConst.MAX_NAME_LENGTH;
    }

    public static boolean validateCarCount(String[] carNames) {
        return carNames.length >= NumberConst.MIN_CAR_COUNT;
    }

    public static boolean validateUniqueCarName(String[] carNames) {
        Set carNameSet = new HashSet();
        for (int i = 0; i < carNames.length; i++) {
            carNameSet.add(carNames[i]);
        }
        if(carNameSet.size() < carNames.length){
            return false;
        }
        return true;
    }
}
