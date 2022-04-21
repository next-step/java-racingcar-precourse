package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.racing.RacingStatus;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionTest {
    @Test
    @DisplayName("자동차 위치를 생성한다.")
    void createCarPosition() {
        // given

        // when
        CarPosition carPosition = new CarPosition();

        // then
        assertThat(carPosition.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차 위치를 기록한다.")
    void recordCarPosition() {
        // given
        CarPosition carPosition = new CarPosition();

        // when
        carPosition.recordPosition(RacingStatus.GO);
        carPosition.recordPosition(RacingStatus.STOP);
        carPosition.recordPosition(RacingStatus.GO);

        // then
        assertThat(carPosition.getPosition()).isEqualTo(2);
        assertThat(carPosition.getPositions()).contains(1, 1, 2);
    }
}
