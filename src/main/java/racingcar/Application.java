package racingcar;

import racingcar.controller.CarController;

public class Application {

    static CarController carController = new CarController();

    public static void main(String[] args) {
        carController.play(carController.getCars(), carController.getTryNumber());
    }
}
