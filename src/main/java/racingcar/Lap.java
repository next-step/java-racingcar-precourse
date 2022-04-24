package racingcar;

import racingcar.util.ValidationUtil;

public class Lap {
    private int lapCount = 0;

    public void setLap(String inputLap) {
        ValidationUtil.validateInteger(inputLap);
        ValidationUtil.validatePositive(inputLap);
        this.lapCount = Integer.parseInt(inputLap);
    }

    public int getLapCount() {
        return this.lapCount;
    }

    public boolean isNotEmpty() {
        return lapCount > 0;
    }
}
