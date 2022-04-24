package racingcar.util;

import org.junit.platform.commons.util.StringUtils;
import racingcar.ui.GameOutput;

public class ValidationUtils {

    private ValidationUtils() { }


    public static boolean isValidCarNames(String input) {
        try {
            validateCarNameInput(input);
            String[] names = input.split(",");
            for (String name : names) {
                ValidationUtils.validateCarName(name);
            }
        } catch (Exception e) {
            GameOutput.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }

    private static void validateCarNameInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }

        String[] names = input.split(",");
        if (names.length == 0) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }

    public static void validateCarName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public static boolean isValidTotalRound(String input) {
        int num = getNumber(input);
        return isValidTotalRound(num);
    }

    public static boolean isValidTotalRound(int input) {
        if (input < 1 || input > 100) {
            throw new IllegalArgumentException("시도 회수는 1부터 100까지 입력 가능합니다.");
        }

        return true;
    }

    private static int getNumber(String input) {
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 회수는 숫자여야 합니다.");
        }
        return num;
    }
}
