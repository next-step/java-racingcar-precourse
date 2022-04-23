package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RacingCarTest {

    RacingCar racingCar;

    @BeforeEach
    void setup() {
        racingCar = new RacingCar("car");
    }

    @Test
    @DisplayName("차가 움직인다.")
    void move() {
        racingCar.move(() -> true);
        Assertions.assertThat(racingCar.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("차가 움직이지 않는다.")
    void stop() {
        racingCar.move(() -> false);
        Assertions.assertThat(racingCar.getPosition()).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("차가 움직일때마다 현재 위치를 히스토리에 쌓는다.")
    void addHistory() {
        racingCar.move(() -> true);
        Assertions.assertThat(racingCar.getPositionHistories().get(0)).isEqualTo(1);

        racingCar.move(() -> true);
        Assertions.assertThat(racingCar.getPositionHistories().get(1)).isEqualTo(2);

        racingCar.move(() -> false);
        Assertions.assertThat(racingCar.getPositionHistories().get(1)).isEqualTo(2);
    }


}