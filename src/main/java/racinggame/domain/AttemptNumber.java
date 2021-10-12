package racinggame.domain;

import racinggame.exception.RacingGameErrorCode;
import racinggame.exception.RacingGameException;

public class AttemptNumber {
    private int number;

    public AttemptNumber(int number) {
        if (number < 1) {
            throw new RacingGameException(RacingGameErrorCode.INVALID_ATTEMPT_NUMBER);
        }

        this.number = number;
    }

    public void decrement() {
        number--;
    }

    public boolean isOver() {
        return number < 1;
    }
}
