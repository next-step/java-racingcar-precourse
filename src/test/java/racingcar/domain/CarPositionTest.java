package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarPositionTest {
    @Test
    void 자동차_위치_입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CarPosition carPosition = new CarPosition();
            carPosition.setPosition(-1);
        });
    }
}