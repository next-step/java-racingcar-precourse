package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @DisplayName("표준 이동 전략을 사용시 5이상이면 차들이 이동한다.")
    @Test
    void move() {

        RacingCars racingCars = new RacingCars(Arrays.asList("kim", "lee"), () -> 5, new StandardMovingStrategy());
        racingCars.moveCars();
        assertThat(racingCars.toString()).isEqualTo("kim : -\nlee : -\n");

    }

    @DisplayName("표준 이동 전략을 사용시 3이하이면 차들은 멈춰있다.")
    @Test
    void stop() {

        RacingCars racingCars = new RacingCars(Arrays.asList("kim", "lee"), () -> 3, new StandardMovingStrategy());
        racingCars.moveCars();
        assertThat(racingCars.toString()).isEqualTo("kim : \nlee : \n");

    }

    @DisplayName("우승자는 한명 이상일 수 있다.")
    @Test
    void winner() {

        RacingCars racingCars = new RacingCars(Arrays.asList("kim", "lee"), () -> 5, new StandardMovingStrategy());

        racingCars.moveCars();
        List<String> winners = racingCars.findWinners();

        assertThat(winners.size()).isGreaterThan(1);

    }

}
