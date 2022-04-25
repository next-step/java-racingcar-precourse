package racingcar.controller;

import racingcar.error.Error;

public class Laps {
    private static final int UNTIL = 0;
    private static final int MIN_VALUE = 1;
    private int laps;

    public Laps(String laps) {
        validationCheck(laps);
        this.laps = Integer.parseInt(laps);
    }

    private void validationCheck(String laps) {
        if (isNumber(laps) && isSmallerThanMin(laps)) {
            throw new IllegalArgumentException(Error.NOT_VALID_LAPS.message());
        }
    }

    private boolean isSmallerThanMin(String laps) {
        return Integer.parseInt(laps) < MIN_VALUE;
    }

    private boolean isNumber(String laps) {
        try {
            Integer.parseInt(laps);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean hasNext() {
        return laps > UNTIL;
    }

    public void lapCountDown() {
        if (!hasNext()) {
            throw new IllegalStateException(Error.HAS_NOT_NEXT_LAP.message());
        }

        laps--;
    }
}
