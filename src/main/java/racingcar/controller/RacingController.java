package racingcar.controller;

import racingcar.factory.CarFactory;
import racingcar.model.CarNames;
import racingcar.model.Cars;
import racingcar.model.TotalLaps;
import racingcar.model.Official;

public class RacingController {

    private Official official;
    private Cars cars;

    public RacingController() {
        init();
    }

    private void init() {
        this.official = new Official();
    }

    public void start() {
        createCars();
        race(cars);
    }

    private void createCars() {
        try {
            CarNames carNames = new CarNames(official.readCarNames());
            this.cars = new CarFactory().getCars(carNames.carNames());
        } catch (IllegalArgumentException e) {
            createCars();
        }
    }

    private void race(Cars cars) {
        try {
            TotalLaps totalLaps = new TotalLaps(official.readTotalLaps());
            official.start();
            cars.race(totalLaps);
            official.announce(cars.winners());
        } catch (IllegalArgumentException e) {
            race(cars);
        }
    }
}
