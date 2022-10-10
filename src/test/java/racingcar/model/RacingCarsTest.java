package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
    @DisplayName("가장 멀리간 자동차의 위치 값 구하는 로직 검증")
    @Test
    void getFarthestLap() {
        RacingCars testCars = arrangeRacingCars();

        Lap farthestLap = testCars.getFarthestLap();

        assertThat(farthestLap.getLap()).isEqualTo(10);
    }

    private RacingCars arrangeRacingCars() {
        List<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(
            new RacingCar(new CarName("test"), new Lap(10), new TestMoveStrategy(true)));
        racingCarList.add(
            new RacingCar(new CarName("test2"), new Lap(2), new TestMoveStrategy(true)));

        return new RacingCars(racingCarList);
    }
}
