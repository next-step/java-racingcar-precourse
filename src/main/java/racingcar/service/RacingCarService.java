package racingcar.service;

import racingcar.model.*;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private Cars cars;

    public String start(List<CarName> carNames, Count count) {
        cars = new Cars(createCars(carNames));
        return cars.race(count);
    }

    public List<Car> createCars(List<CarName> carNames) {
        List<Car> cars = new ArrayList<>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public String findFinalWinner() {
        return cars.searchFinalWinner();
    }

}
