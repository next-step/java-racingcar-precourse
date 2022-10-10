package racingcar.controller;

import racingcar.service.RacingCarService;

public class GameController {
    RacingCarService racingCarService = new RacingCarService();

    public void gameStart() {
        racingCarService.racingGameStart();
    }
}
