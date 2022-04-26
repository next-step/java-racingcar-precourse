package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar("sae");
    }

    @Test
    void 자동차에_이름생성_1번_전진() {
        racingCar.moveOnCondition(4);

        assertThat(racingCar.getRacingCarName()).isEqualTo(new RacingCarName("sae"));
        assertThat(racingCar.getLocation()).isEqualTo("-");
    }

    @Test
    void 자동차에_이름생성_멈춤() {
        racingCar.moveOnCondition(1);

        assertThat(racingCar.getRacingCarName()).isEqualTo(new RacingCarName("sae"));
        assertThat(racingCar.getLocation()).isEqualTo("");
    }
}
