package racingcar;

import racingcar.common.RandomGenerator;
import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = createCars();
        RacingCarGame racingCarGame = new RacingCarGame(cars, new RandomNumCondition(new RandomGenerator(0, 9)));

        GameRound numOfRound = getNumOfRound();
        for (int i = 0; i < numOfRound.getRound(); i++) {
            racingCarGame.play();
            ResultView.showResult(racingCarGame);
        }
        ResultView.showWinners(racingCarGame);
    }

    private static List<Car> createCars() {
        try {
            CarNames carNames = InputView.scanCarNames();
            return Car.createBatch(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createCars();
        }
    }

    private static GameRound getNumOfRound() {
        try {
            return new GameRound(InputView.scanNumOfRound());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getNumOfRound();
        }
    }
}
