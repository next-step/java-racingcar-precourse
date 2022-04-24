package racingcar.view;

import racingcar.utils.ValidUtil;

public class RoundCount {
    private final int roundCount;

    public RoundCount(String roundCount) {
        ValidUtil.emptyString(roundCount);
        validNumber(roundCount);
        validLessZero(roundCount);
        this.roundCount = Integer.parseInt(roundCount);
    }

    private void validNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다");
        }
    }

    private void validLessZero(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다");
        }
    }

    public int getRoundCount() {
        return roundCount;
    }
}
