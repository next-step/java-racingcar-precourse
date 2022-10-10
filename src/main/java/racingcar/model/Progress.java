package racingcar.model;

import racingcar.utils.ErrorHandler;

public class Progress {
    private final int count;

    public Progress(int count) {
        if (!validateCount(count)) {
            throw new IllegalArgumentException(ErrorHandler.PROGRESS_COUNT_UNDER_ZERO_ERROR);
        }
        this.count = count;
    }

    private boolean validateCount(int count) {
        return count > 0;
    }

    public int getCount() {
        return this.count;
    }
}
