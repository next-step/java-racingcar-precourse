package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovingConditionTest {

    @Test
    @DisplayName("자동차에 전달되는 조건은 0보다 작은 수를 가질 수 없다")
    void invalid_negative_number() {
        //given
        int number = -1;

        //when
        Throwable throwable = catchThrowable(() -> new MovingCondition(number));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차에 전달되는 조건은 9보다 큰 수를 가질 수 없다")
    void invalid_greater_then_9() {
        //given
        int number = 10;

        //when
        Throwable throwable = catchThrowable(() -> new MovingCondition(number));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }
}
