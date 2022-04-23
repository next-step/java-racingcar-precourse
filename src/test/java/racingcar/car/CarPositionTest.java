package racingcar.car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {
    static CarPosition carPosition;

    @BeforeAll
    static void setup() {
        carPosition = new CarPosition();
        carPosition.moveForward();
        carPosition.moveForward();
    }

    @Test
    void 자동차_전진시_위치_숫자_검증() {
        assertThat(carPosition.toNumber()).isEqualTo(2);
    }

    @Test
    void 자동차_전진시_위치_텍스트_검증() {
        assertThat(carPosition.toResultText()).isEqualTo("--");
    }
}
