package racingcar.domain;

import java.util.regex.Pattern;

public class PlayCount {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    private final int value;

    public PlayCount(String input) {
        if(!isNumeric(input)){
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
        this.value = Integer.parseInt(input);
    }

    private int getValue() {
        return value;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public boolean isLast(int index) {
        return getValue() == index;
    }
}
