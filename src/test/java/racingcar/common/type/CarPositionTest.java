package racingcar.common.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.common.type.CarPosition.MOVING_FORWARD;

class CarPositionTest {

    @Test
    @DisplayName("MOVING_FORWARD 이상이면 전진")
    void moveForward() {
        //given
        final CarPosition position = new CarPosition();

        assertRandomNumberInRangeTest(() -> {
                    position.moveForwardRandom();
                    position.moveForwardRandom();
                    position.moveForwardRandom();
                    assertThat(position.getCarPosition()).isEqualTo(2);
                },
                MOVING_FORWARD, MOVING_FORWARD + 1, MOVING_FORWARD - 1
        );
    }
}