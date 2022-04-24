package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarMovableStrategyTest {

    @DisplayName("랜덤 숫자가 4 이상일 경우 이동가능한지")
    @Test
    void isMoveTest() {
        // given
        MovableStrategy movableStrategy = () -> RandomNumber.generate(4, 9) >= 4;

        // when
        boolean isMovable = movableStrategy.isMovable();

        // then
        assertThat(isMovable).isTrue();
    }

    @DisplayName("랜덤 숫자가 4 미만일 경우 이동 실패하는지 테스트")
    @Test
    void isMoveFailTest() {
        // given
        MovableStrategy movableStrategy = () -> RandomNumber.generate(0, 3) >= 4;

        // when
        boolean isMovable = movableStrategy.isMovable();

        // then
        assertThat(isMovable).isFalse();
    }

}
