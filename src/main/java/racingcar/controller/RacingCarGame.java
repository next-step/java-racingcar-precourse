package racingcar.controller;

import racingcar.model.CarName;
import racingcar.service.RacingCarService;
import racingcar.utils.RacingConsole;

import java.util.List;

public class RacingCarGame {
    private final RacingCarService racingCarService;
    private final RacingConsole racingConsole;

    public RacingCarGame(RacingCarService racingCarService,
                         RacingConsole racingConsole) {
        this.racingCarService = racingCarService;
        this.racingConsole = racingConsole;
    }

    public void startGame() {
        List<CarName> carNames = racingConsole.getCarName();
        String result = racingCarService.start(carNames, racingConsole.getCount());
        String winnerResult = racingCarService.findFinalWinner();
        racingConsole.printResult(result, winnerResult);
    }

}
