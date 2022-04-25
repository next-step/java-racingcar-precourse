package racingcar.domain;

import racingcar.common.Messages;

public class RepeatCount {
    private final int count;

    public RepeatCount(String count) {
        validationNumber(count);
        validationZeroNumber(Integer.parseInt(count));

        this.count = Integer.parseInt(count);
    }

    public int getCount() {
        return count;
    }

    private void validationNumber(String text) {
        if (!isNumber(text)) {
            throw new IllegalArgumentException(Messages.REPEAT_NOT_NUMBER);
        }
    }

    private void validationZeroNumber(int count) {
        if (count == 0) {
            throw new IllegalArgumentException(Messages.REPEAT_NOT_ZERO);
        }
    }

    private boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
