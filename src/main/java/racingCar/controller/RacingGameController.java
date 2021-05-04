package racingCar.controller;

import racingCar.domain.RacingGame;
import racingCar.view.InputView;
import racingCar.view.TryResultsView;

public class RacingGameController {

    public void start() {
        String[] carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingGame racingGame = new RacingGame(carNames, tryCount);

        while (racingGame.availableGame()) {
            TryResultsView tryResultsView = racingGame.race();
            tryResultsView.print();
        }

    }

}
