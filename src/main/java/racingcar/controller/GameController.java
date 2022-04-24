package racingcar.controller;

import racingcar.domain.CarNumber;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private RacingGame racingGame;
    private CarNumber carNumber;

    public void play() {
        inputCarNamesAndCreateRacingGame();
        inputCarNumberAndCreateCarNumber();

        racingGame.play(carNumber.getNumber());
        OutputView.printRacingResult(racingGame);
    }

    private void inputCarNamesAndCreateRacingGame() {
        boolean isValidInputNames = false;
        while (!isValidInputNames) {
            try {
                racingGame = new RacingGame(InputView.printInputRacingCarNames());
                isValidInputNames = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private void inputCarNumberAndCreateCarNumber() {
        boolean isValidInputNumber = false;
        while (!isValidInputNumber) {
            try {
                carNumber = new CarNumber(InputView.printInputTryCount());
                isValidInputNumber = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printMessage(illegalArgumentException.getMessage());
            }
        }
    }
}
