package racingcar.service;

import racingcar.domain.*;
import racingcar.strategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarService {
    private static final CarService carService = new CarService();

    public static CarService getInstance() {
        return carService;
    }

    public void result() {
        RacingGame racingGame = new RacingGame(cars(), movement());
        Winners winners = new Winners(result(racingGame));
        OutputView.printWinner(winners.get());
    }

    private Cars cars() {
        try {
            return new Cars(InputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage("올바르지 않은 자동차 이름입니다. 다시 입력해주세요.");
            return cars();
        }
    }

    private Movement movement() {
        try {
            String numberOfMoves = InputView.inputNumberOfMoves();
            return new Movement(numberOfMoves);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage("시도 횟수는 숫자여야 한다.");
            return movement();
        }
    }

    private List<Car> result(RacingGame racingGame) {
        List<Car> carList = null;
        while (racingGame.continuable()) {
            carList = racingGame.game(new RandomMovingStrategy());
            OutputView.printResult(carList);
        }
        return carList;
    }
}
