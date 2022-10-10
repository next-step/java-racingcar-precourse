package racingcar.controller;

import racingcar.service.InputService;
import racingcar.service.RacingService;

public class RacingController {

    public void run (InputService inputService) {
        new RacingService(inputService).start();
    }
}
