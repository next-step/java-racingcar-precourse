package racingcar.model;

import racingcar.utils.InputValidator;

public class RepeatCount {
    private final String repeatCount;

    public RepeatCount(String repeatCount) {
        InputValidator.isNumber(repeatCount);
        InputValidator.isNumberInRange(repeatCount);
        this.repeatCount = repeatCount;
    }

    public Integer getRepeatCount() {
        return Integer.parseInt(this.repeatCount);
    }
}
