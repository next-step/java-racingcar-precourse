package racingcar.model;

import racingcar.common.Constants;

public class Progress {
    private final int progress;

    private Progress(int progress) {
        validateProgress(progress);
        this.progress = progress;
    }

    /**
     * Progress creation method
     *
     * @param progress amount of progress
     * @return new Progress
     */
    public static Progress from(int progress) {
        return new Progress(progress);
    }

    /**
     * the progress value verification logic used in the creation process.
     *
     * @param progress amount of progress
     */
    private void validateProgress(int progress) {
        if (progress < 0) {
            throw new IllegalArgumentException(Constants.COMMON_ERROR_HEADER.concat("음수 상태 값은 허용되지 않습니다."));
        }
    }

    /**
     * Returns progress
     *
     * @return progress
     */
    public int getProgress() {
        return progress;
    }

    /**
     * Returns new Progress incremented by the amount. If the result of the increment operation is negative, an
     * exception is raised.
     *
     * @param amount amount to increase progress
     * @return new Progress
     * @throws IllegalArgumentException Occurs when the result of the increment operation is negative
     */
    public Progress increaseProgress(int amount) throws IllegalArgumentException {
        return new Progress(this.progress + amount);
    }
}
