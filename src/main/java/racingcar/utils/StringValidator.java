package racingcar.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringValidator {

    private static final String SPLIT_VALUE = ",";
    private static final int SPLIT_LIMIT = -1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String INVALID_NAME_OVER_LENGTH_MESSAGE = "[ERROR] 자동차 이름은 5글자 이하로 입력해주세요.";
    private static final int MIN_CAR_NAME_LENGTH = 0;
    private static final String INVALID_NAME_UNDER_LENGTH_MESSAGE = "[ERROR] 자동차 이름은 1글자 이상 입력해주세요.";
    private static final String DUPLICATED_NAME_MESSAGE = "[ERROR] 자동차 이름은 중복없이 입력해주세요.";

    public static boolean isValidCarInput(String carList) {
        try {
            List<String> cars = Arrays.asList(carList.split(SPLIT_VALUE, SPLIT_LIMIT));
            validCarListCheck(cars);
            duplicateCarListCheck(cars);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static void validCarListCheck(List<String> cars) {
        for (String car : cars) {
            lengthCheck(car);
        }
    }

    public static void duplicateCarListCheck(List<String> cars) {
        Set<String> checkSet = new HashSet<>(cars);
        if (checkSet.size() != cars.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_MESSAGE);
        }
    }

    public static void lengthCheck(String car) {
        if (car.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_OVER_LENGTH_MESSAGE);
        }
        if (car.length() == MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_UNDER_LENGTH_MESSAGE);
        }
    }

}
