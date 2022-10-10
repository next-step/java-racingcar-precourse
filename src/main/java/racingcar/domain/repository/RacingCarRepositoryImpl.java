package racingcar.domain.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;

public class RacingCarRepositoryImpl implements RacingCarRepository {

    List<Car> cars = new ArrayList<>();

    @Override
    public void save(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }
}
