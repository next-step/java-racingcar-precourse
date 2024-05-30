package racinggame.controller;

import racinggame.service.RacingGameService;
import racinggame.view.RacingGameResultView;
import racinggame.view.UserInputView;

public class RacingGameController {
    private UserInputView userInputView;
    private RacingGameResultView racingGameResultView;
    private RacingGameService racingGameService;

    public RacingGameController(UserInputView userInputView, RacingGameResultView racingGameResultView, RacingGameService racingGameService) {
        this.userInputView = userInputView;
        this.racingGameResultView = racingGameResultView;
        this.racingGameService = racingGameService;
    }

    public void startGame() {
        String carNames = userInputView.getCarNames();
        int numOfAttempts = userInputView.getNumOfAttempts();
        racingGameService.initCar(carNames);
        racingGameService.race(numOfAttempts);
        racingGameResultView.printCarPositions(racingGameService.getCars());
        racingGameResultView.printWinners(racingGameService.getWinners());

    }
}
