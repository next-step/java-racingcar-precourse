package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void RacingCar_객체_생성() {
        RacingCar racingCar = new RacingCar("자동차1");
        assertThat("자동차1").isEqualTo(racingCar.getName());
        assertThat(0).isEqualTo(racingCar.getGoCount());
    }

    @Test
    void 전진_테스트() {
        RacingCar racingCar = new RacingCar("자동차1");
        racingCar.goRacingCar();
        assertThat(1).isEqualTo(racingCar.getGoCount());
    }
}
