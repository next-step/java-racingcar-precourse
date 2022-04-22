package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.movement.MovementStatus;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionsTest {
    @Test
    @DisplayName("자동차 위치를 생성한다.")
    void createCarPosition() {
        // given

        // when
        CarPositions carPositions = new CarPositions();

        // then
        assertThat(carPositions.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차 위치를 기록한다.")
    void recordCarPosition() {
        // given
        CarPositions carPositions = new CarPositions();

        // when
        carPositions.recordPosition(MovementStatus.GO);
        carPositions.recordPosition(MovementStatus.STOP);
        carPositions.recordPosition(MovementStatus.GO);

        // then
        assertThat(carPositions.getPosition()).isEqualTo(2);
        assertThat(carPositions.getPositions()).contains(1, 1, 2);
    }
}
