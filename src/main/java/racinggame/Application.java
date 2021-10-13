package racinggame;

import racinggame.domain.*;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarNames carNames = InputView.getCarNames();
        LapCount lapCount = InputView.getLapCount();
        List<Car> cars = CarFactory.from(carNames);

        GameResult gameResult = new RacingGame(cars).run(lapCount);

        ResultView.printEveryLapResult(gameResult);
        ResultView.printWinners(gameResult);
    }
}
