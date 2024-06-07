package controller;

import java.util.regex.Pattern;
import java.util.HashSet;

public class Validation {

    /**
     * 자동차 이름들이 유효한지 판별하는 함수
     * 유효하지 않으면 IllegalArgumentException이 발생
     *
     * @param carNames - 사용자가 입력한 자동차 이름들
     */
    public static void checkCarNames(String[] carNames) {
        if (!CarNamesValidation.isWithinRange(carNames) ||
            CarNamesValidation.isDuplication(carNames)) {
            throw new IllegalArgumentException();
        }
        for (String carName : carNames) {
            if (!CarNamesValidation.isEnglish(carName) ||
                !CarNamesValidation.isWithin5Chars(carName)) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * 시도 횟수가 유효한지 판별하는 함수
     * 유효하지 않으면 IllegalArgumentException이 발생
     *
     * @param number - 사용자가 입력한 시도 횟수
     */
    public static void checkNumber(String number) {
        if (!NumberValidation.isDigit(number) || !NumberValidation.isWithinRange(number)) {
            throw new IllegalArgumentException();
        }
    }
}

class CarNamesValidation {

    private static final int MAX_NUMBER_OF_CAR_NAMES = 5;

    /**
     * 자동차 이름이 5자 이하인지 판별하는 함수
     *
     * @param carName - 사용자가 입력한 자동차 이름들 중 하나
     * @return 5자 이하면 true, 그렇지 않으면 false
     */
    static boolean isWithin5Chars(String carName) {
        if (carName.length() <= 5) {
            return true;
        }
        return false;
    }

    /**
     * 자동차 이름이 영문인지 판별하는 함수
     *
     * @param carName - 사용자가 입력한 자동차 이름들 중 하나
     * @return 영문이면 true, 그렇지 않으면 false
     */
    static boolean isEnglish(String carName) {
        return Pattern.matches("^[a-zA-Z]*$", carName);
    }

    /**
     * 자동차 이름들 중 중복된 이름이 있는지 판별하는 함수
     *
     * @param carNames - 사용자가 입력한 자동차 이름들
     * @return 중복이 있으면 true, 그렇지 않으면 false
     */
    static boolean isDuplication(String[] carNames) {
        HashSet<String> set = new HashSet<>();

        for (String element : carNames) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 자동차 이름들이 1개 이상이고 MAX_NUMBER_OF_CAR_NAMES 이하인지 판별하는 함수
     *
     * @param carNames - 사용자가 입력한 자동차 이름들
     * @return 유효 범위 내의 개수이면 true, 그렇지 않으면 false
     */
    static boolean isWithinRange(String[] carNames) {
        if (carNames.length > 0 && carNames.length <= MAX_NUMBER_OF_CAR_NAMES) {
            return true;
        }
        return false;
    }
}

class NumberValidation {

    private static final int MAX_NUMBER = 10;

    /**
     * 시도 횟수가 숫자인지 판별하는 함수
     *
     * @param number - 사용자가 입력한 시도 횟수
     * @return 숫자이면 true, 그렇지 않으면 false
     */
    static boolean isDigit(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * 시도 횟수가 1 이상이고 MAX_NUMBER 이하인지 판별하는 함수
     *
     * @param number - 사용자가 입력한 시도 횟수
     * @return 유효 범위 내의 횟수이면 true, 그렇지 않으면 false
     */
    static boolean isWithinRange(String number) {
        if (Integer.parseInt(number) > 0 && Integer.parseInt(number) <= MAX_NUMBER) {
            return true;
        }
        return false;
    }
}
