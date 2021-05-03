package racingcargame.controller;

import racingcargame.service.RacingCarGameService;
import racingcargame.view.ConsoleInput;
import racingcargame.view.ConsoleOutput;

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
        Integer moveCount = ConsoleInput.inputMoveCount();
        racingCarGameService.race(moveCount);
        ConsoleOutput.printResultMessage();
        ConsoleOutput.printResult(racingCarGameService.getResultString());
    }
}
