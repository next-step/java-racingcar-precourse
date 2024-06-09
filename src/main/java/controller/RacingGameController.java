package controller;

import model.Car;
import model.RacingGame;
import view.InputView;

import java.util.List;

public class RacingGameController {

    public void run() {
        List<Car> carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        RacingGame racingGame = new RacingGame(carNames);
        racingGame.play(tryCount);
    }
}
