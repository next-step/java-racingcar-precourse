package controller;

import model.Cars;
import view.Output;

public class GameController {

    private Cars cars = new Cars();

    public void setCars(String[] carNames) {
        try {
            Validation.checkCarNames(carNames);
            this.cars.setCars(carNames);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
