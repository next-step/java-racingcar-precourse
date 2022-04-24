package racingcar.domain;

import racingcar.common.Message;

public class RoundCount {
    private int roundCount;

    public RoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public RoundCount(String tryCount) {
        validateTryCount(tryCount);
        this.roundCount = Integer.parseInt(tryCount);
    }

    public int getRoundCount() {
        return this.roundCount;
    }

    private void validateTryCount(String tryCount) {
        if (!isNaturalNumber(tryCount)) {
            throw new IllegalArgumentException(Message.ERROR_TRY_COUNT_NOT_NUMBER);
        }
    }

    private boolean isNaturalNumber(String tryCount) {
        try {
            return Integer.parseInt(tryCount) > 0 ? true : false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void addRoundCount() {
        this.roundCount++;
    }

    public boolean isEqualTryCount(RoundCount tryCount) {
        return this.roundCount == tryCount.getRoundCount();
    }
}
