package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = RacingCar.getFromName("bsy");
    }

    @Test
    void 자동차_전진() {
        racingCar.move(5);
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_정지() {
        racingCar.move(3);
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_전진_정지() {
        racingCar.move(5);
        assertThat(racingCar.getPosition()).isEqualTo(1);
        racingCar.move(3);
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }
}
