package racingcar.domain;

import racingcar.view.ConsolePrinter;
import racingcar.view.Messages;

public class RacingCnt {
    private static final int MIN_RACING_CNT_VAL = 1;
    private int racingCnt;

    public RacingCnt(String input) {
        int inputNum = validateNumberType(input);
        racingCnt = validateMinValue(inputNum);
    }

    private int validateNumberType(String input) {
        int inputNum = 0;
        try {
            inputNum = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ConsolePrinter.printConsoleMsg(Messages.ERROR_RACING_CNT_NUM_TYPE);
            throw new IllegalArgumentException();
        }
        return inputNum;
    }

    private int validateMinValue(int inputNum) {
        if (inputNum < MIN_RACING_CNT_VAL) {
            ConsolePrinter.printConsoleMsg(Messages.ERROR_RACING_CNT_MIN_VALUE);
            throw new IllegalArgumentException();
        }
        return inputNum;
    }

    public int getRacingCnt() {
        return this.racingCnt;
    }
}
