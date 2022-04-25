package racingcar.model;

import racingcar.validation.TotalLapsValidation;

public class TotalLaps implements TotalLapsValidation {

    private final int totalLaps;

    public TotalLaps(String totalLaps) {
        this.totalLaps = totalLaps(totalLaps);
    }

    public int totalLaps() {
        return totalLaps;
    }

    private int totalLaps(String totalLaps) {
        return validTotalLaps(totalLaps);
    }
}
