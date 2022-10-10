package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.Result;
import racingcar.domain.Winners;
import racingcar.strategy.RandomStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        RacingCars racingCars = getRacingCars();

        int maxRaceNumber = getInputMaxRaceNumber();
        RacingGame racingGame = RacingGame.of(racingCars, new RandomStrategy(), maxRaceNumber);
        racingGame.play();

        Result result = racingGame.getResult();
        outputView.printResult(result);

        Winners winners = result.getWinner();
        outputView.printWinners(winners);
    }

    private int getInputMaxRaceNumber() {
        int maxRaceNumber;
        try {
            maxRaceNumber = inputView.inputMaxRaceNumber();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getInputMaxRaceNumber();
        }
        return maxRaceNumber;
    }

    private RacingCars getRacingCars() {
        RacingCars racingCars;
        try {
            String carNames = inputView.inputCarNames();
            racingCars = RacingCars.of(carNames);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getRacingCars();
        }
        return racingCars;
    }
}
