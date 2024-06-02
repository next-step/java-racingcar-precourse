package controller;

import model.Cars;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void gameStart() {
        String names = inputView.InputCar();
        Cars cars = new Cars(names);

        int repeat = inputView.InputNumber();
        repeatValidation(repeat);
        repeatRun(repeat, cars);
        outputView.printWinners(cars.getWinners());
    }

    void repeatRun(int repeat, Cars cars) {
        System.out.println("result:");

        while (repeat > 0) {
            cars.runCars();
            outputView.printCarStatus(cars.getCars());
            repeat--;
        }
    }
    void repeatValidation(int repeat) {
        if (repeat < 1) {
            throw new IllegalArgumentException("[ERROR]Must repeat more than once");
        }
    }

}
