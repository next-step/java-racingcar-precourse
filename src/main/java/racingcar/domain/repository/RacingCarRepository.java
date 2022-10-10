package racingcar.domain.repository;

import java.util.List;
import racingcar.domain.car.Car;

public interface RacingCarRepository {

    void save(Car car);

    List<Car> findAll();
}
