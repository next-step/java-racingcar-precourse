package racingCar.controller;

import racingCar.domain.Car;
import racingCar.domain.Cars;
import racingCar.domain.ExceedCarNameException;
import racingCar.domain.RacingGame;
import racingCar.view.InputView;
import racingCar.view.ResultView;
import racingCar.view.TryResultsView;

import java.util.List;

public class RacingGameController {

    public void start() {
        String[] carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingGame racingGame = new RacingGame(carNames, tryCount);

        try {
            ResultView.printResultIntro();
            while(racingGame.availableGame()) {
                TryResultsView tryResultsView = racingGame.race();
                tryResultsView.print();
            }
            Cars winnerCars = racingGame.winnerCars();
            ResultView.printWinners(winnerCars);
        } catch (ExceedCarNameException e) {
            ResultView.printError(e.getMessage());
        }

    }

}
