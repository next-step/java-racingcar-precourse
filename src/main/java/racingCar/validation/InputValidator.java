package racingCar.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int MAX_COUNT_OF_CARS = 100;
    private static final int MIN_COUNT_OF_CARS = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 1;
    private static final String TOO_MANY_CARS_ERR = "\n[ERROR] 자동차의 수는 1대 이상 100대 이하만 가능합니다.";
    private static final String INVALID_INPUT_LENGTH_ERR = "\n[ERROR] 자동차의 이름은 5글자만 가능합니다.";
    private static final String DUPLICATE_INPUT_ERR = "\n[ERROR] 자동차 이름에 중복이 존재합니다.";
    private static final String NOT_NUMERIC_INPUT_ERR = "\n[ERROR] 숫자만 입력이 가능합니다.";
    private static final String OUT_OF_RANGE_NUM_ERR = "\n[ERROR] 1이상 100이하의 숫자만 입력이 가능합니다.";

    /**
     * 입력된 자동차 이름 문자열의 유효성을 검증하는 메서드
     * @param inputNames
     */
    public static void validateInputCarName(String inputNames) {
        List<String> nameList = splitInputName(inputNames);

        validateCountOfCars(nameList);
        validateNameLength(nameList);
        validateNameDuplication(nameList);
    }

    /**
     * 검증하기 위해 문자열을 콤마(,) 기준으로 split
     * @param inputNames
     * @return name list
     */
    private static List<String> splitInputName(String inputNames) {
        return Arrays.asList(
                inputNames.replaceAll("\\s+", "")
                        .split(",")
        );
    }

    /**
     * 자동차의 개수 제한에 대한 검증
     * 1대 이상 100대 이하
     * @param nameList
     */
    private static void validateCountOfCars(List<String> nameList) {
        int count = nameList.size();
        if(count < MIN_COUNT_OF_CARS || MAX_COUNT_OF_CARS < count) {
            throw new IllegalArgumentException(TOO_MANY_CARS_ERR);
        }
    }

    /**
     * 자동차 이름의 길이 제한을 검증
     * 1자 이상 5자 이하
     * @param nameList
     */
    private static void validateNameLength(List<String> nameList) {
        for (String s : nameList) {
            int len = s.length();
            if(len < MIN_NAME_LENGTH || MAX_NAME_LENGTH < len) {
                throw new IllegalArgumentException(INVALID_INPUT_LENGTH_ERR);
            }
        }
    }

    /**
     * 자동차 이름의 중복 여부를 검증
     * @param nameList
     */
    private static void validateNameDuplication(List<String> nameList) {
        Set<String> nameSet = new HashSet<>(nameList);
        if(nameList.size() != nameSet.size()) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_ERR);
        }
    }

    /**
     * 시도 횟수를 검증하기 위한 메서드
     * @param inputNum
     */
    public static void validateInputTryNum(String inputNum) {
        isNumeric(inputNum);
        validateNumInRange(inputNum);
    }

    /**
     * 입력된 값이 숫자에 해당하는지 검증
     * @param inputNum
     */
    private static void isNumeric(String inputNum) {
        try {
            Integer.parseInt(inputNum);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_INPUT_ERR);
        }
    }

    /**
     * 숫자의 값이 유효 범위를 벗어나는지 검증
     * 1이상 100이하
     * @param inputNum
     */
    private static void validateNumInRange(String inputNum) {
        int num = Integer.parseInt(inputNum);
        if(num < MIN_NUMBER || MAX_NUMBER < num) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUM_ERR);
        }
    }
}
