package racingcar.service;

import racingcar.model.*;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private Cars cars;

    public ResultView race(List<CarName> carNames, AttemptCount attemptCount) {
        cars = new Cars(createCars(carNames));
        return cars.race(attemptCount);
    }

    private List<Car> createCars(List<CarName> carNames) {
        List<Car> cars = new ArrayList<>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public String findFinalWinner() {
        return cars.findFinalWinner();
    }
}
