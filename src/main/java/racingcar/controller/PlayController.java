package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.model.Winner;


import java.util.Iterator;

public class PlayController {
    private static PlayController playController;

    private PlayController() {}

    public synchronized static PlayController getInstance() {
        if (playController == null)
            playController = new PlayController();
        return playController;
    }

    public Iterator<Car> progressRound(CarRepository autowiredCarRepository) {
        autowiredCarRepository.startRound();
        return autowiredCarRepository.asIterator();
    }

    public void insertCarInRepository(String[] cars, CarRepository carRepository) {
        for (String car : cars) {
            carRepository.addCar(new Car(car));
        }
    }

    public Winner findWinner(CarRepository carRepository) {
        return new Winner(carRepository);
    }
}
