package racingcar.controller;


import racingcar.domain.car.Cars;
import racingcar.domain.common.TryCount;
import racingcar.movestategy.RandomMove;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class PlayRacingGame {

    private final InputView inputView;
    private final ResultView resultView;
    private Cars cars;
    private TryCount tryCount;

    public PlayRacingGame() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void startGame() {
        inputCarNames();
        inputTryCount();
        startCars(tryCount.getTryCount());
    }

    private void inputCarNames() {
        String carNames = inputView.insertCarNames();
        carsInit(carNames);
    }

    private void inputTryCount() {
        try {
            String count = inputView.insertTryCount();
            tryCount = TryCount.of(count);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            inputTryCount();
        }
    }

    private void carsInit(String carName) {
        try {
            cars = Cars.of(carName, new RandomMove());
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            inputCarNames();
        }
    }

    private void startCars(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            resultView.printCarsDistance(cars, tryCount);
        }
        endGame(cars);
    }

    private void endGame(Cars cars) {
        resultView.endRacing();
        resultView.printWinners(cars);
    }
}
