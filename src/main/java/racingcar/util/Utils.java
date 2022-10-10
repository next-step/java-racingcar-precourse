package racingcar.util;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Utils {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    public static final int MIN_TRY_COUNT = 1;

    public static boolean isAlphabet(String str) {
        return str.matches("^[a-zA-Z]*$");
    }

    public static int generateRandomNumber() {
        return pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public static int validateTryCount(String input) {
        if (!isNumber(input)) {
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }
        int tryCount = Integer.parseInt(input);
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("1 이상의 숫자만 입력 가능합니다.");
        }
        return tryCount;
    }

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<String> separateInput(String input) {
        List<String> carNames = new ArrayList<>();
        for (String carName : input.split(",")) {
            carNames.add(carName.trim());
        }
        return carNames;
    }
}
