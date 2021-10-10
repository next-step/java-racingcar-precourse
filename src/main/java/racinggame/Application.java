package racinggame;

import racinggame.common.enums.Messages;
import racinggame.controller.CarController;
import racinggame.domain.CarFacroty;
import racinggame.domain.Cars;
import racinggame.view.CarView;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        CarView carView = new CarView();
        CarController carController = new CarController(carView);
        CarFacroty carFacroty = carController.validInputCarNames();
        int attempt = carController.validInputNumberGames();
        Cars cars = carFacroty.enter();
        carView.printMessage(Messages.PLAY_STATUS.getMessage());
        carController.calculatePrint(attempt, cars);
        carView.printResult(cars.winner());
    }
}
