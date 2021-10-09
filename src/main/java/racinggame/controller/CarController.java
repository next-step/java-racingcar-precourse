package racinggame.controller;

import racinggame.common.enums.Messages;
import racinggame.domain.CarFacroty;
import racinggame.domain.Cars;
import racinggame.utils.Utils;
import racinggame.view.CarView;

public class CarController {

    private final CarView carView;

    public CarController(CarView carView) {
        this.carView = carView;
    }

    public void playGame() {
        carView.printMessage(Messages.CAR_NAME_INPUT.getMessage());
        CarFacroty carFacroty = new CarFacroty(Utils.getInputString());
        carView.printMessage(Messages.NUMBER_ATTEMPT.getMessage());
        int attempt = Utils.getStringToInt(Utils.getInputString());
        Cars cars = carFacroty.enter();
        carView.printMessage(Messages.PLAY_STATUS.getMessage());
        calculate(attempt, cars);
        carView.printResult(cars.winner());
    }

    private void calculate(int attempt, Cars cars) {
        for (int i = 0; i < attempt; i++) {
            cars.play(Utils.getRandomList(cars.getCarsSize()));
            carView.printStatus(cars.getCars());
            carView.printLine();
        }
    }
}
