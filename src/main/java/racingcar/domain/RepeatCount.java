package racingcar.domain;

import racingcar.constant.ErrorMessageConst;

public class RepeatCount {
    public static final int VALUE_REPEATCOUNT_MIN = 1;
    public static final int VALUE_REPEATCOUNT_MAX = Integer.MAX_VALUE;

    private int repeatCount;

    public RepeatCount(int repeatCount) {
        if(repeatCount > VALUE_REPEATCOUNT_MAX || repeatCount < VALUE_REPEATCOUNT_MIN){
            throw new IllegalArgumentException(
                    String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_REPEAT_COUNT_NATURAL_NUMBER_FORMAT,
                            VALUE_REPEATCOUNT_MIN, VALUE_REPEATCOUNT_MAX));
        }
        this.repeatCount = repeatCount;
    }

    public int getValue() {
        return repeatCount;
    }
}
