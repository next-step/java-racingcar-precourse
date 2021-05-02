package racingcargame.controller;

import racingcargame.service.RacingCarGameService;
import racingcargame.view.ConsoleInput;

public class RacingCarGameController {
    RacingCarGameService racingCarGameService;

    public RacingCarGameController(RacingCarGameService racingCarGameService) {
        this.racingCarGameService = racingCarGameService;
    }

    public void run() {
        playRacingCarGame();
    }

    private void playRacingCarGame() {
        String carNames = ConsoleInput.inputRacingCarNames();
        racingCarGameService.makeCars(carNames);


    }
}
