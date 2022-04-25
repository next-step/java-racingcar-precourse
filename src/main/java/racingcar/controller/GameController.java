package racingcar.controller;

import racingcar.domain.CarCollection;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public GameController() {
    }

    public static void run() {
        String carNames = InputView.readCarNames();
        CarCollection carCollection = new CarCollection(carNames);

        int tryCount = InputView.readTryCount();
        for (int i = 0; i < tryCount; i++) {
            carCollection.tryMoving();
            OutputView.printProgress(RaceResult.from(carCollection));
        }
        OutputView.printWinners(RaceResult.from(carCollection));
    }
}
