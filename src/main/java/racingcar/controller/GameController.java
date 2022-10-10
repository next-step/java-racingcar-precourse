package racingcar.controller;

import racingcar.client.CarNamesClient;
import racingcar.client.PlayResultClient;
import racingcar.client.TryCountClient;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;

public class GameController {
    private GameController() {
    }

    public static void play() {
        runGame(
                CarNamesClient.inputCarNamesUntilSuccess(),
                TryCountClient.inputTryCountUntilSuccess()
        );
    }

    private static void runGame(Cars cars, TryCount tryCount) {
        System.out.println("실행 결과");

        for (int moveCount = 0; moveCount < tryCount.getCount(); moveCount++) {
            cars.moveByRandomAccelPower();

            PlayResultClient.printCurrentCarPositions(cars);
        }

        PlayResultClient.printWinnerCarNames(cars.getWinnerCarNames());
    }
}