package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingResultTest {

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars();
        String[] cars = {"A", "B", "C"};

        for (String car : cars) {
            racingCars.addRacingCar(new RacingCar(new RacingCarName(car)));
        }
    }

    @Test
    void 우승자가_한명일_경우_결과를_출력한다() {
        // given
        List<RacingCar> racingCars = this.racingCars.getRacingCars();
        racingCars.get(0).move(9);
        racingCars.get(0).move(9);
        racingCars.get(0).move(9);

        RacingResult racingResult = new RacingResult(racingCars);

        // when
        String winners = racingResult.winners();

        // then
        Assertions.assertThat(winners).contains("최종 우승자: A");
    }

    @Test
    void 우승자가_두명일_경우_결과를_출력한다() {
        // given
        List<RacingCar> racingCars = this.racingCars.getRacingCars();
        racingCars.get(0).move(9);
        racingCars.get(0).move(9);
        racingCars.get(0).move(9);

        racingCars.get(1).move(9);
        racingCars.get(1).move(9);
        racingCars.get(1).move(9);

        RacingResult racingResult = new RacingResult(racingCars);

        // when
        String winners = racingResult.winners();

        // then
        Assertions.assertThat(winners).contains("최종 우승자: A,B");
    }
}
