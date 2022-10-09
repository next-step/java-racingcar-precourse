package racingcar;

import racingcar.context.RacingCarCycle;

public class RacingCarStarter {

    private final RacingCarCycle racingCarCycle;

    public RacingCarStarter() {
        this.racingCarCycle = new RacingCarDefaultCycle();
    }

    public void start() {
        racingCarCycle.onCars();
        racingCarCycle.onTryCount();
        racingCarCycle.onPlay();
        racingCarCycle.onFinish();
    }
}
