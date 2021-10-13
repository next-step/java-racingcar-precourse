package racinggame;

import racinggame.common.Const;
import racinggame.controller.CarController;
import racinggame.controller.RaceController;
import racinggame.domain.Car;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int tryCount = 0;

    public void start() {
        setGameInfo();
        play();
        printResult();
    }

    private void setGameInfo() {
        cars = getCarNames();
        getTryCount();
    }

    private List<Car> getCarNames() {
        List<Car> cars = CarController.generateCars(InputView.carNames());
        return cars;
    }

    private void getTryCount() {
        String inputTryCount = InputView.tryCount();
        tryCount = RaceController.parseIntTryCount(inputTryCount);
    }

    private void play() {
        System.out.println('\n' + Const.EXECUTION_RESULT);
        for (int i = 0; i < tryCount; i++) {
            cars.forEach(Car::forward);
            OutputView.printCarsPosition(cars);
        }
    }

    private void printResult() {
        RaceController.findIsWinners(cars);
        OutputView.printWinners(cars);
    }
}

