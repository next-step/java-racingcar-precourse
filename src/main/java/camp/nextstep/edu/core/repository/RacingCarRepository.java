package camp.nextstep.edu.core.repository;

import camp.nextstep.edu.core.Car;

import java.util.List;

public interface RacingCarRepository {

    void save(List<Car> car);

    List<Car> findAll();

}
