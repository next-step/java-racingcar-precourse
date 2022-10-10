package racingcar;

import racingcar.domain.CarRace;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        String carNameString = InputView.inputCarCount();
        String tryCount = InputView.inputTryCount();

        CarRace carRace = new CarRace(carNameString, tryCount);

        ResultView.printResultStart();

        ResultView.printResult(carRace.racingGameStart());

        ResultView.printWinner(carRace.extractWinner());
    }
}
