package racingcar.domain;

import racingcar.Constant;

import java.util.regex.Pattern;

public class RaceCount {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    private final int value;

    public RaceCount(String input) {
        if(!isNumeric(input)){
            throw new IllegalArgumentException(Constant.ERROR_RACE_ROUND);
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
