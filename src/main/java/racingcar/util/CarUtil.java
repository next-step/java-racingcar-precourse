package racingcar.util;

import static racingcar.model.Cars.CARS_SIZE_MIN;

public class CarUtil {

    public static final String INVALID_CAR_NAMES = "자동차 이름 입력 오류. (참가자는 2명 이상) 다시 입력하세요.";
    public static final String INVALID_ROUND = "회차 입력 오류. (숫자만 입력가능) 다시 입력하세요.";

    public static void validateCarNames(String input) {
        if (input.split(",").length < CARS_SIZE_MIN) {
            throw new IllegalArgumentException(INVALID_CAR_NAMES);
        }
    }

    public static void validateRound(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_ROUND);
        }
    }

    public static String dot(int input, String dot) {
        String result = "";
        for (int i = 0; i < input; i++) {
            result += dot;
        }
        return result;
    }

}
