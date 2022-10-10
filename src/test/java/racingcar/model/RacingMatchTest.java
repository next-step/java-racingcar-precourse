package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingMatchTest {
    @DisplayName("winner 계산 로직 검증")
    @Test
    void getWinnerCarNames() {
        RacingCars testCars = arrangeTestCars();
        RacingMatch racingMatch = new RacingMatch(testCars, new Lap(5));

        CarNames winnerCarNames = racingMatch.getWinnerCarNames();

        assertThat(winnerCarNames.getNames()).hasSize(2);
        assertThat(winnerCarNames.getNames().get(0).getName()).isEqualTo("test");
        assertThat(winnerCarNames.getNames().get(1).getName()).isEqualTo("test3");
    }

    private RacingCars arrangeTestCars() {
        List<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(new RacingCar(new CarName("test"), new TestMoveStrategy(true)));
        racingCarList.add(new RacingCar(new CarName("test2"), new TestMoveStrategy(false)));
        racingCarList.add(new RacingCar(new CarName("test3"), new TestMoveStrategy(true)));

        return new RacingCars(racingCarList);
    }
}