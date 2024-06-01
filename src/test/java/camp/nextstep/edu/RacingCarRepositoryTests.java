package camp.nextstep.edu;

import camp.nextstep.edu.core.Car;
import camp.nextstep.edu.core.repository.RacingCarRepository;
import camp.nextstep.edu.core.repository.impl.InMemoryRacingCarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarRepositoryTests {
    private RacingCarRepository racingCarRepository;

    @BeforeEach
    void setUp() {
        racingCarRepository = new InMemoryRacingCarRepository();
    }

    @Test
    void saveCars() {
        // given
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"));
        racingCarRepository.save(cars);

        // when
        List<Car> savedCars = racingCarRepository.findAll();
        // then
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            Car savedCar = savedCars.get(i);

            assertThat(car.getName()).isEqualTo(savedCar.getName());
        }
    }

    @Test
    void findAll() {
        // given
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"));
        racingCarRepository.save(cars);

        // when
        List<Car> savedCars = racingCarRepository.findAll();

        // then
        assertThat(savedCars).hasSize(3);
    }
}
