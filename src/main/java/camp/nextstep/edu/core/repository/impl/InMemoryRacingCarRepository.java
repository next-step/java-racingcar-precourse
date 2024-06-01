package camp.nextstep.edu.core.repository.impl;

import camp.nextstep.edu.core.Car;
import camp.nextstep.edu.core.repository.RacingCarRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRacingCarRepository implements RacingCarRepository {

    private final List<Car> cars = new ArrayList<>();

    @Override
    public void save(List<Car> car) {
        cars.addAll(car);
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(cars);
    }
}
