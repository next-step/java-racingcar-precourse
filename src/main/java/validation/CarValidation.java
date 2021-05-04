package validation;

import message.Message;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CarValidation {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public static void doThings(String[] cars) {
        Set<String> carSet = new HashSet<>();
        for (String car : cars) {
            isAvailableRange(car);
            isDuplicated(carSet, car);
        }
    }

    private static void isAvailableRange(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NAME_RANGE);
        }
    }

    private static void isDuplicated(Set<String> carSet, String carName) {
        if (!carSet.add(carName)) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NAME_DUPLICATE);
        }
    }

}
