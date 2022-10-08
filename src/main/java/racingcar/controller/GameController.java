package racingcar.controller;

import racingcar.domain.CarNumber;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static racingcar.utils.CommonUtil.*;

public class GameController {
    private RacingGame racingGame;
    private CarNumber carNumber;

    public void play() {
        InputView.printInputRacingCarNames();
        inputCarNamesAndValidation();
        InputView.printInputTryCount();
        inputCarNumberAndValidation();

        racingGame.start(carNumber.getNumber());
        OutputView.printRacingGameResult(racingGame);
    }

    private void inputCarNamesAndValidation() {
        boolean isValidInputNames = false;
        while (!isValidInputNames) {
            try {
                racingGame = new RacingGame(inputText());
                isValidInputNames = true;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    private void inputCarNumberAndValidation() {
        boolean isValidInputNumber = false;
        while (!isValidInputNumber) {
            try {
                carNumber = new CarNumber(inputText());
                isValidInputNumber = true;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }
}
