package racingcar.nextstep.infrastructure.car;

import racingcar.nextstep.domain.car.Car;
import racingcar.nextstep.domain.car.CarName;
import racingcar.nextstep.domain.car.Cars;
import racingcar.nextstep.domain.car.CarsName;
import racingcar.nextstep.domain.car.service.CarCreator;

import java.util.ArrayList;
import java.util.List;

public class CarCreatorImpl implements CarCreator {

    @Override
    public Cars createCars(CarsName carsName) {
        final List<Car> carList = new ArrayList<>();

        for (CarName carName : carsName.getCarNames()) {
            final Car car = Car.of(carName);
            carList.add(car);
        }

        return Cars.of(carList);
    }
}
