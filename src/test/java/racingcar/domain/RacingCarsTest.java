package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {

    private final List<RacingCar> racingCarList = new ArrayList<>();

    @BeforeEach
    void init() {
        racingCarList.add(new RacingCar(new RacingCarName("bob")));
        racingCarList.add(new RacingCar(new RacingCarName("cat")));
    }

    @Test
    void 공동_우승자_찾기() {
        racingCarList.get(0).racing(new RacingNumber(5));
        racingCarList.get(1).racing(new RacingNumber(6));
        RacingCars racingCars = new RacingCars(racingCarList);
        assertThat(racingCars.findWinners()).isEqualTo("bob,cat");
    }

    @Test
    void 단독_우승자_찾기() {
        racingCarList.get(0).racing(new RacingNumber(5));
        racingCarList.get(1).racing(new RacingNumber(3));
        RacingCars racingCars = new RacingCars(racingCarList);
        assertThat(racingCars.findWinners()).isEqualTo("bob");
    }
}
