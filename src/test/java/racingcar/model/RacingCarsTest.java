package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class RacingCarsTest {

    @Test
    @DisplayName("우승자 이름 리스트를 찾는다.")
    void findWinners() {
        RacingCars racingCars = RacingCars.from("aaa,bbb,ccc");

        List<RacingCar> racingCarList = racingCars.getRacingCarList();
        racingCarList.get(0).move(() -> true);
        racingCarList.get(1).move(() -> false);
        racingCarList.get(2).move(() -> false);

        List<String> winners = racingCars.findWinners();

        Assertions.assertThat(winners.size()).isEqualTo(1);
        Assertions.assertThat(winners.get(0)).isEqualTo("aaa");
    }

}