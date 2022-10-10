package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.type.ErrorMessageType.GREATER_THAN_END_INCLUSIVE;
import static racingcar.type.ErrorMessageType.LESS_THAN_START_INCLUSIVE;
import static racingcar.type.NumberRangeType.END_INCLUSIVE;
import static racingcar.type.NumberRangeType.START_INCLUSIVE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    @Test
    @DisplayName("random 값이 9 보다 큰 경우 예외가 발생한다.")
    void movingForward_randomValueGreaterThanEndInclusive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Racing(END_INCLUSIVE.getNumber() + 1);
                })
                .withMessageContaining(GREATER_THAN_END_INCLUSIVE.getMessage());
    }

    @Test
    @DisplayName("random 값이 0 보다 작은 경우 예외가 발생한다.")
    void movingForward_randomValueLessThanStartInclusive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Racing(START_INCLUSIVE.getNumber() - 1);
                })
                .withMessageContaining(LESS_THAN_START_INCLUSIVE.getMessage());
    }

    @Test
    @DisplayName("random 값이 4 이상일 경우 전진한다.")
    void movingForward_randomValueGreaterOrEqualThanFour() {
        Racing racing = new Racing(4);
        assertTrue(racing.isMovingForward());
    }

    @Test
    @DisplayName("random 값이 3 이하의 값이면 전진하지 못한다.")
    void stay_randomValueLessOrEqualThanThree() {
        Racing racing = new Racing(3);
        assertFalse(racing.isMovingForward());
    }
}