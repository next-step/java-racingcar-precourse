package racingcar.controller;

import racingcar.model.Cars;
import racingcar.service.RacingService;
import racingcar.view.OutputView;

public class RacingController {
    private RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void playRacing() {
        Cars cars = racingService.generateCarsFromUser();
        int rounds = racingService.getGameRounds();
        processRacing(cars, rounds);
        finishGame(cars);
    }

    private void processRacing(Cars cars, int rounds) {
        for (int i = 0; i < rounds; i++) {
            racingService.processGameRound(cars);
            OutputView.printEmptyLine();
        }
    }

    private void finishGame(Cars cars) {
        racingService.getGameWinner(cars);
    }
}
