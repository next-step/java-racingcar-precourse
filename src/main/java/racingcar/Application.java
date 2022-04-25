package racingcar;

import racingcar.domain.CarRacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        String carNameWithComma = InputView.inputCarNameWithComma();
        int numberOfAttempts = InputView.inputNumberOfAttempts();
        CarRacingGame carRacingGame = CarRacingGame.of(carNameWithComma, numberOfAttempts);

        ResultView resultView = new ResultView(carRacingGame.start());
        resultView.printRecordResult();
        resultView.printWinner();

    }
}
