package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidUtils {
    private static final int MINIMUM_PARTICIPATE_CAR_COUNT = 2;
    private static final String CAR_NAME_SEPARATOR = ",";

    private ValidUtils() {
    }

    public static void validParticipateCarCount(String[] carNames) {
        if (carNames.length < MINIMUM_PARTICIPATE_CAR_COUNT) {
            throw new IllegalArgumentException(Message.ERROR_MINIMUM_PARTICIPATE_CAR.getMessage());
        }
    }

    public static String[] validDuplicateName(String inputCarNames) {
        String[] carNames = inputCarNames.split(CAR_NAME_SEPARATOR);
        Set<String> distinctCarNames = new HashSet<>(Arrays.asList(carNames));
        if (carNames.length != distinctCarNames.size()) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NAME_DUPLICATE.getMessage());
        }
        return carNames;
    }

    public static void validDuplicateSeparator(String inputCarNames) {
        if (inputCarNames.contains(",,")) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NAME_DUPLICATE_SEPARATOR.getMessage());
        }
    }

}
