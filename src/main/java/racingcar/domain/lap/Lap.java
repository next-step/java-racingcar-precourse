package racingcar.domain.lap;

import racingcar.domain.InputData;

public class Lap {
    private int lap;

    public Lap(InputData lap) {
        String lapString = lap.getInputData();
        this.lap = Integer.parseInt(lapString);
    }

    public int getLap() {
        return lap;
    }
}
