package racingcar.nextstep.infrastructure.car;

import racingcar.nextstep.domain.car.Cars;
import racingcar.nextstep.domain.car.CarsName;
import racingcar.nextstep.domain.car.service.CarCreator;
import racingcar.nextstep.domain.car.service.CarService;

public class CarServiceImpl implements CarService {

    private final CarCreator carCreator;

    public CarServiceImpl(CarCreator carCreator) {
        this.carCreator = carCreator;
    }

    @Override
    public Cars createCars(CarsName carsName) {
        return carCreator.createCars(carsName);
    }
}
