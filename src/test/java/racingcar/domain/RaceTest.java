package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Error;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RaceTest {
    @DisplayName("레이스의 시도 횟수는 0보다 커야 한다")
    @Test
    void 시도횟수_예외_테스트() {
        assertThatThrownBy(() -> {
            Cars cars = new Cars(Arrays.asList(new Car("차")));
            new Race(cars).start(0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.SHOULD_OVER_MINIMUM_ROUND.toString());
    }
}
