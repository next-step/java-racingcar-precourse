package racingcar.model;

import java.util.regex.Pattern;

public class Racing {
    private static final String NUMBER_REGAX = "^[0-9]*$";
    private final int moveCount;

    public Racing(String moveCount) {
        if(!isNumber(moveCount)) {
            throw new IllegalArgumentException();
        }
        this.moveCount = Integer.valueOf(moveCount);
    }

    private boolean isNumber(String input) {
        return Pattern.matches(NUMBER_REGAX, input);
    }
}
