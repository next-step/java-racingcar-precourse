package racinggame;

import racinggame.domain.Car;
import racinggame.domain.CarFactory;
import racinggame.domain.GameResult;
import racinggame.domain.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int lapCount = InputView.getLapCount();
        List<Car> cars = CarFactory.from(carNames);

        GameResult gameResult = new RacingGame(cars).run(lapCount);

        ResultView.printEveryLapResult(gameResult);
        ResultView.printWinners(gameResult);
    }
}
