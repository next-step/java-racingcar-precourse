package racingcar.model;

import static racingcar.common.Constants.COMMON_ERROR_HEADER;
import static racingcar.common.Constants.ERROR_TRIAL_RANGE_OVER;

public class Laps {
    private final int lapCount;

    private Laps(int lapCount) throws IllegalArgumentException {
        validateInput(lapCount);
        this.lapCount = lapCount;
    }

    /**
     * Car creation method
     *
     * @param input input
     * @return new Laps
     */
    public static Laps from(int input) {
        return new Laps(input);
    }

    /**
     * Returns lapCount
     *
     * @return lapCount
     */
    public int getLapCount() {
        return lapCount;
    }

    /**
     * Returns the laps decreased by the amount from the current laps. If the result of the decrease operation is
     * negative, an exception is raised.
     *
     * @param amount amount to decrease laps
     * @return new Laps
     * @throws IllegalArgumentException Occurs when the result of the decrease operation is negative.
     */
    public Laps decreaseLaps(int amount) throws IllegalArgumentException {
        return new Laps(this.lapCount - amount);
    }

    /**
     * the input verification logic used in the creation process.
     *
     * @param input input
     */
    private void validateInput(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(getRangeErrorMessage());
        }
    }

    /**
     * Returns RangeErrorMessage
     *
     * @return RangeErrorMessage
     */
    private String getRangeErrorMessage() {
        return COMMON_ERROR_HEADER.concat(ERROR_TRIAL_RANGE_OVER);
    }


}
