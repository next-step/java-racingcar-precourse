package racingcar.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.enums.CarMovingStateEnum;

class CarMovingStateUtilTest {
    private static final int MOVING_FORWARD_NUMBER = 4;
    private static final int STOP_NUMBER = 0;

    @Test
    void 전진_범위값_시_전진() {
        assertRandomNumberInRangeTest(
                () -> assertThat(CarMovingStateUtil.judgeMovingState()).isEqualTo(CarMovingStateEnum.MOVE),
                MOVING_FORWARD_NUMBER
        );
    }

    @Test
    void 정지_범위값_시_정지() {
        assertRandomNumberInRangeTest(
                () -> assertThat(CarMovingStateUtil.judgeMovingState()).isEqualTo(CarMovingStateEnum.STOP),
                STOP_NUMBER
        );
    }

}