package domain;

import static view.MessageConstant.NOT_POSITIVE_NUMBER_ERROR;

public class RacingCount {
    int count;

    public RacingCount(int count) {
        if (!ValidationUtils.validatePositiveNumber(count)) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR);
        }
        this.count = count;
    }

    public int getCount() {
        return count;
    }

}
