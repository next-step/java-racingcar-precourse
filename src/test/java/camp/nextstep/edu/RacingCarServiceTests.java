package camp.nextstep.edu;

import camp.nextstep.edu.core.Car;
import camp.nextstep.edu.core.RacingResult;
import camp.nextstep.edu.core.repository.RacingCarRepository;
import camp.nextstep.edu.core.repository.impl.InMemoryRacingCarRepository;
import camp.nextstep.edu.core.service.RacingCarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarServiceTests {
    RacingCarRepository racingCarRepository;
    RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        racingCarRepository = new InMemoryRacingCarRepository();
        racingCarService = new RacingCarService(racingCarRepository);
    }

    @Test
    void runCarRacing() {
        // given
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"));
        racingCarService.registerCars(cars);

        // when
        RacingResult result = racingCarService.runCarRacing(5);

        // then
        assertThat(result.racingLogs()).hasSize(5);
        assertThat(result.winners()).hasSize(1);
    }

    @Test
    void getWinners() {
        // given
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"));
        racingCarService.registerCars(cars);

        // when
        List<Car> winners = racingCarService.getWinners();

        // then
        assertThat(winners).hasSize(3);
    }
}
