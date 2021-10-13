package racinggame.validation;

import racinggame.common.Const;

import java.util.HashSet;
import java.util.Set;


public class CarValidation {
    public static void isCarValidate(String[] cars) {
        Set<String> carSet = new HashSet<>();
        for (String car : cars) {
            isAvailableRange(car);
            isDuplicated(carSet, car);
        }
    }

    protected static boolean isAvailableRange(String name) {
        if (name.length() < Const.MIN_NAME_LENGTH || name.length() > Const.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Const.ERROR_CAR_NAME_RANGE);
        }
        return true;
    }

    protected static boolean isDuplicated(Set<String> carSet, String carName) {
        if (!carSet.add(carName)) {
            throw new IllegalArgumentException(Const.ERROR_CAR_NAME_DUPLICATE);
        }
        return true;
    }

}
