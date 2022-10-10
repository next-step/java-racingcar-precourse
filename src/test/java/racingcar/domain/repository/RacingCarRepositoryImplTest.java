package racingcar.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.carname.CarName;
import racingcar.domain.car.carname.validation.DefaultCarNameValidator;
import racingcar.domain.car.move.DefaultMove;

class RacingCarRepositoryImplTest {

    RacingCarRepository repository = new RacingCarRepositoryImpl();

    @Test
    void save_find() {
        Car saveCar = new Car(new CarName("pobi", new DefaultCarNameValidator()), new DefaultMove());
        repository.save(saveCar);
        List<Car> findCar = repository.findAll();
        assertThat(saveCar).isEqualTo(findCar.get(0));
    }

}