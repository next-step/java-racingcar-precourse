package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("숫자 조건 이동 기능 관련")
class NumberConditionMovementTest {
    @DisplayName("4 이상이면 전진한다.")
    @Test
    void forward() {
        // given
        Movement movement = NumberConditionMovement.from(() -> 4);

        // when
        boolean forward = movement.forward();

        // then
        assertThat(forward).isTrue();
    }

    @DisplayName("3 이상이면 멈춘다.")
    @Test
    void stop() {
        // given
        Movement movement = NumberConditionMovement.from(() -> 3);

        // when
        boolean forward = movement.forward();

        // then
        assertThat(forward).isFalse();
    }
}
