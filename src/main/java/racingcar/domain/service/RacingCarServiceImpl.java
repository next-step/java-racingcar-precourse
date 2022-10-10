package racingcar.domain.service;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.carname.CarName;
import racingcar.domain.car.carname.CarNames;
import racingcar.domain.car.carname.validation.DefaultCarNameValidator;
import racingcar.domain.car.carname.validation.DefaultCarNamesValidator;
import racingcar.domain.car.move.DefaultMove;
import racingcar.domain.repository.RacingCarRepository;

public class RacingCarServiceImpl implements RacingCarService {

    RacingCarRepository repository;

    public RacingCarServiceImpl(RacingCarRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createCars(String names) {
        CarNames carNames = new CarNames(names, new DefaultCarNamesValidator());
        for (CarName carName : carNames.createCarNames(new DefaultCarNameValidator())) {
            repository.save(new Car(carName, new DefaultMove()));
        }
    }

    @Override
    public List<Car> findCars() {
        return repository.findAll();
    }
}
