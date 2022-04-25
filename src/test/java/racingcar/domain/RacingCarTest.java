package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private RacingCarName racingCarName;

    @BeforeEach
    void setUp() {
        racingCarName = new RacingCarName("abcd");
    }

    @Test
    void 자동차_이동이_가능한_경우_이동한다() {
        RacingCar racingCar = new RacingCar(racingCarName);
        racingCar.move(7);

        Assertions.assertThat(racingCar.getCurrentLocation()).isEqualTo(1);
    }

    @Test
    void 자동차_이동이_불가능한_경우_이동하지않는다() {
        RacingCar racingCar = new RacingCar(racingCarName);
        racingCar.move(1);

        Assertions.assertThat(racingCar.getCurrentLocation()).isEqualTo(0);
    }

    @Test
    void 자동차_이동시_거리를_표시한다() {
        RacingCar racingCar = new RacingCar(racingCarName);
        racingCar.move(4);

        Assertions.assertThat(racingCar.currentLocationMark()).isEqualTo(
                String.format("%s : %s", racingCarName.getName(), RacingCar.MARK)
        );
    }
}
