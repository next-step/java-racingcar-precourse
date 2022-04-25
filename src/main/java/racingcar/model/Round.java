package racingcar.model;

import racingcar.exception.IllegalArgumentException;

public class Round {
    private int round;

    public static final int FINISHED = 0;
    public static final int MIN_VALUE = 1;

    public static final String NOT_NUMBER_ERROR_MSG = "[ERROR] 시도 횟수는 숫자만 입렵할 수 있습니다.";
    public static final String MIN_ROUND_NUMER_ERROR_MSG = "[ERROR] 시도 횟수는 1이상의 숫자만 입력할 수 있습니다.";

    public Round(String str) throws IllegalArgumentException {
        if (!isNumber(str)) {
            throw IllegalArgumentException.NOT_NUMBER_ROUND;
        }

        int round = Integer.parseInt(str);
        if (!isMoreThanMinValue(round)) {
            throw IllegalArgumentException.LESS_THAN_MIN_NUMBER_ROUND;
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
