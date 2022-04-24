package racingcar.controller;

import racingcar.domain.Racing;
import racingcar.domain.wrapper.Racers;
import racingcar.domain.wrapper.RoundCount;

public class RacingController {
    public static void start(final Racers racers, final RoundCount roundCount) {
        Racing racing = new Racing(racers, roundCount);
        racing.start();
    }
}
