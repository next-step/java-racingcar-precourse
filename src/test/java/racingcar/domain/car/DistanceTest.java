package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.error.ErrorMessage;

class DistanceTest {
    @ParameterizedTest(name = "음수 거리 예외")
    @ValueSource(ints = {-1, -10, -100})
    public void 음수_거리_예외(int distance) {
        assertThatThrownBy(() -> Distance.from(distance)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MSG_INVALID_DISTANCE.getMessage());
    }

    @DisplayName("compareTo 양수 테스트")
    @Test
    public void compareTo_양수_테스트() {
        assertThat(Distance.from(5).compareTo(Distance.from(1))).isPositive();
    }

    @DisplayName("compareTo 음수 테스트")
    @Test
    public void compareTo_음수_테스트() {
        assertThat(Distance.from(3).compareTo(Distance.from(8))).isNegative();
    }
}