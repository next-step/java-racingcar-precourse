package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarPositionTest {

    CarPosition carPosition = new CarPosition();

    @DisplayName("시작 포지션 확인")
    @Test
    void initPositionTest() {
        assertThat(carPosition.getPosition()).isEqualTo(0);
    }


}