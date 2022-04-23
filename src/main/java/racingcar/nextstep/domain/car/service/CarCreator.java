package racingcar.nextstep.domain.car.service;

import racingcar.nextstep.domain.car.Cars;
import racingcar.nextstep.domain.car.CarsName;

public interface CarCreator {
    Cars createCars(CarsName carsName);
}
