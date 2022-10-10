package racingcar.domain;

import static racingcar.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;
import static racingcar.type.ErrorMessageType.TRY_COUNT_NOT_ALLOW_LESS_THAN_ONE;

import racingcar.exception.InputWrongValueException;

public class TryCount {

    private final int count;

    public TryCount(String count) {
        this.count = parseInt(count);
        validateNumberRange();
    }

    private int parseInt(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new InputWrongValueException(INPUT_ONLY_ALLOW_NUMBER.getMessage());
        }
    }

    private void validateNumberRange() {
        if (this.count < 1) {
            throw new InputWrongValueException(TRY_COUNT_NOT_ALLOW_LESS_THAN_ONE.getMessage());
        }
    }

    public int getCount() {
        return count;
    }
}
