package racingcar.utils;

import java.util.regex.Pattern;

public class MovementUtils {
    public static int validateOnlyNumber(String input) {
        if(!Pattern.matches("^\\d*$", input)){
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
        return Integer.parseInt(input);
    }
}
