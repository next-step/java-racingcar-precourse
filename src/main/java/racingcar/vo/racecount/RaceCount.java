package racingcar.vo.racecount;

import racingcar.common.error.ErrorMessage;

public class RaceCount {

    private static final int MIN = 1;

    private int count;

    private RaceCount(int count) {
        this.count = count;
        validate();
    }

    public static RaceCount from(int count) {
        return new RaceCount(count);
    }

    public Integer toInteger() {
        return count;
    }

    private void validate() {
        if (this.count < MIN) {
            throw new IllegalArgumentException(ErrorMessage.MSG_INVALID_RACE_COUNT.getMessage());
        }
    }
}
