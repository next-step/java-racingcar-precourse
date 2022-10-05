package racingcar.model;

import static racingcar.common.Constants.*;

public class Circuit {
    private RacingCarList racingCarList;
    private Laps laps;

    /**
     * This is a laps setter method, and duplicate assignments are not possible. If you try to allocate a duplicate, an
     * exception will be thrown.
     *
     * @param laps Laps
     * @throws IllegalArgumentException Occurs on duplicate assignment
     */
    public void setLaps(Laps laps) throws IllegalArgumentException {
        if (this.laps != null) {
            throw new IllegalStateException(COMMON_ERROR_HEADER.concat(ERROR_INITIALIZE_DUPLICATE));
        }
        this.laps = laps;
    }

    /**
     * This is a racingCarList setter method, and duplicate assignments are not possible. If you try to allocate a
     * duplicate, an exception will be thrown.
     *
     * @param racingCarList RacingCarList
     * @throws IllegalArgumentException Occurs on duplicate assignment
     */
    public void setRacingCarList(RacingCarList racingCarList) throws IllegalArgumentException {
        if (this.racingCarList != null) {
            throw new IllegalStateException(COMMON_ERROR_HEADER.concat(ERROR_INITIALIZE_DUPLICATE));
        }
        this.racingCarList = racingCarList;
    }

    /**
     * Returns the status of all cars in racingCarList.
     *
     * @return the status of all cars
     */
    public String[] getAllStatus() {
        return racingCarList.getAllStatus();
    }

    /**
     * Returns the current laps
     *
     * @return the current laps
     */
    public int getCurrentLaps() {
        return laps.getLapCount();
    }

    /**
     * Returns new Laps decreased by the amount. If amount is negative number, an exception is raised.
     *
     * @param amount the amount to decrease laps
     * @throws IllegalArgumentException Occurs when amount is negative
     */
    public void decreaseLaps(int amount) throws IllegalArgumentException {
        this.laps = this.laps.decreaseLaps(amount);
    }

    /**
     * Call the race method of racingCarList.
     */
    public void race() {
        racingCarList.race();
        decreaseLaps(1);
    }

    /**
     * Returns a string with a list of final winners.
     *
     * @return a list of final winners.
     */
    public String getWinnerListString() {
        return FINAL_WINNER.concat(String.join(",", racingCarList.getWinnerList()));
    }
}
