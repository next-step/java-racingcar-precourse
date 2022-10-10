package racingcar.domain;

import racingcar.common.ErrorMessage;
import racingcar.common.ValidUtils;

public class TryCount {

    public static final int MINIMUM_TRY_COUNT = 0;
    private int count;

    public TryCount(String count) {
        validTryCount(count);
        this.count = Integer.parseInt(count);
    }

    private void validTryCount(String numberString) {

        if (ValidUtils.stringIsNotDigit(numberString)) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_NOT_A_NUMBER.toString());
        }

        if (ValidUtils.integerLessThenMinNumber(Integer.parseInt(numberString), MINIMUM_TRY_COUNT)) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_LESS_THEN_ZERO.toString());
        }
    }


    public void tryOnce() {
        count--;
    }

    public boolean hasTryCount() {
        return count > MINIMUM_TRY_COUNT;
    }

}
