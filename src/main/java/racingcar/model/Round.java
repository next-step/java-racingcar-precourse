package racingcar.model;

import racingcar.exception.IllegalArgumentException;

public class Round {
    private int round;

    public static final int FINISHED = 0;
    public static final int MIN_VALUE = 1;

    public Round(String str) throws IllegalArgumentException {
        if (!isNumber(str)) {
            throw new IllegalArgumentException(IllegalArgumentException.MSG_NOT_NUMBER);
        }

        int round = Integer.parseInt(str);
        if (!isMoreThanMinValue(round)) {
            throw new IllegalArgumentException(IllegalArgumentException.MSG_MIN_ROUND_NUMBER);
        }
        this.round = round;
    }

    private boolean isNumber(String str) {
        final String numberCheckRegex = "\\d+";
        return str.matches(numberCheckRegex);
    }

    private boolean isMoreThanMinValue(int value) {
        return (value >= MIN_VALUE);
    }

    public void playRound() {
        round--;
    }

    public boolean isFinished() {
        return round == FINISHED;
    }
}
