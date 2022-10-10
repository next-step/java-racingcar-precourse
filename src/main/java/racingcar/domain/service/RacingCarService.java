package racingcar.domain.service;

import java.util.List;
import racingcar.domain.car.Car;

public interface RacingCarService {

    void createCars(String carNames);

    List<Car> findCars();
}
