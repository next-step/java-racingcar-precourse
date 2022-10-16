package racingcar;

import racingcar.controller.CarController;
import racingcar.controller.GameFactory;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController(new GameFactory());
        carController.start();
    }
}
