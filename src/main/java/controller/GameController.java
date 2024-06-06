package controller;

import java.util.Map;
import java.util.Random;
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

    public Map<String, String> addCarsDistance() {
        for (String carName : this.cars.getCars().keySet()) {
            int randNum = (int) (Math.random() * 10);
            if (randNum >= 4) {
                this.cars.addDistance(carName);
            }
        }
        return this.cars.getCars();
    }
}
