package racingcar.model.car;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarNameSplitter {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String CAR_NAME_SPLITTER = "\\s*,\\s*"; // 쉼표(,)로 구분해서 앞뒤 공백 제거

    private CarNameSplitter() {
    }

    public static String[] split(String carNamesWithComma) {
        validateIfEmpty(carNamesWithComma);

        String trimCarNames = carNamesWithComma.trim(); // 앞뒤 공백 제거
        String[] carNames = trimCarNames.split(CAR_NAME_SPLITTER);

        validate(trimCarNames, carNames);

        return carNames;
    }

    private static void validateIfEmpty(String carNamesWithComma) {
        if (carNamesWithComma == null || carNamesWithComma.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validate(String carNamesWithComma, String[] carNames) {
        validateIfArrayLength(carNamesWithComma, carNames.length);
        validateIfEmptyCarNames(carNames);
        validateIfDuplicateCarName(carNames);
    }

    private static void validateIfArrayLength(String trimCarNames, int actualArrayLength) {
        if (actualArrayLength == 0) {
            throw new IllegalArgumentException();
        }
        int totalLength = trimCarNames.length();
        int namesLength = trimCarNames.replace(CAR_NAME_DELIMITER, "").length();
        int commaLength = totalLength - namesLength;
        int expectedArrayLength = commaLength + 1;
        if (expectedArrayLength != actualArrayLength) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIfEmptyCarNames(String[] carNames) {
        for (String carName : carNames) {
            validateIfEmptyCarName(carName);
        }
    }

    private static void validateIfEmptyCarName(String carName) {
        if (carName.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIfDuplicateCarName(String[] carNames) {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(carNames));
        if (carNameSet.size() != carNames.length) {
            throw new IllegalArgumentException();
        }
    }
}
