package racingcar.model.service;

import java.util.ArrayList;
import racingcar.model.domain.Car;

public interface RaceService {
    String getResult(ArrayList<Car> cars, int times);

    ArrayList<Car> validateCars(String names);

    int validateTimes(String times);

    Car raceStart(Car car, int times);
}
