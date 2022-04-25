package racingcar.domain;

import racingcar.common.ErrorMessage;

/**
 * 사용자에게 입력 받은 경주 시도 횟수
 *
 * @author suji
 * @date 2022-04-23
 **/
public class RacingCount {

    private static final String POSITIVE_NUMBER_REGEX = "^\\d+$";
    private static final String NUMBER_ZERO = "0";

    private final Integer count;

    public RacingCount(String inputCount) {
        this.count = validate(inputCount);
    }

    private Integer validate(String inputCount) {
        if (isEmpty(inputCount)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_RACING_COUNT_EMPTY);
        }
        if (!isPositiveNumber(inputCount)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_RACING_COUNT_RANGE);
        }
        try {
            return Integer.parseInt(inputCount);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_RACING_COUNT_MAX);
        }
    }

    private boolean isEmpty(String inputCount) {
        return inputCount == null || inputCount.trim().length() == 0;
    }

    private boolean isPositiveNumber(String inputCount) {
        return inputCount.matches(POSITIVE_NUMBER_REGEX) && !NUMBER_ZERO.equals(inputCount);
    }

    public boolean isEnd(int tryCount) {
        if (this.count > tryCount) {
            return false;
        }
        return true;
    }

    public Integer getCount() {
        return count;
    }
}
