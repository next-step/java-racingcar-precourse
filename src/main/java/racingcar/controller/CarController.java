package racingcar.controller;

import racingcar.service.CarService;

public class CarController {
    private static final CarController carController = new CarController();

    public static CarController getInstance() {
        return carController;
    }

    public void game() {
        CarService carService = CarService.getInstance();
        carService.result();
    }
}
