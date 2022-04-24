package racingcar.controller;

import racingcar.domain.GameManager;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {
    public static void startRacing() {
        String[] carNameList = InputView.enterCars();
        GameManager gameManager = new GameManager(carNameList);
        int tryCount = InputView.enterTryCount();
        System.err.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            gameManager.startRacing();
            ResultView.racingResult(gameManager.getCarList());
        }
        ResultView.racingWinnerResult(gameManager.getRacingWinners());
    }
}
