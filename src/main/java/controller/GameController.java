package controller;

import model.Cars;

public class GameController {

    private Cars cars = new Cars();

    public void setCars(String[] carNames) {
        this.cars.setCars(carNames);
    }
}
