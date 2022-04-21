package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {
    @Test
    @DisplayName("랜덤으로 넘어오는 인자가 4이상이면 전진이므로, 거리는 1이다.")
    void 인자가_3이상이면_전진() {
        final Distance distance = Distance.fromFactor(4);
        assertThat(distance).isEqualTo(MoveState.FORWARD.getDistance());
    }

    @Test
    @DisplayName("랜덤으로 넘어오는 인자가 3이하면 정지이므로, 거리는 0이다.")
    void 인자가_3이하면_정지() {
        final Distance distance = Distance.fromFactor(3);
        assertThat(distance).isEqualTo(MoveState.IDLE.getDistance());
    }
    @Test
    @DisplayName("주행거리를 문자열로 표현할 수 있다.")
    void 주행거리를_문자로_표현() {
        final Distance distance = Distance.valueOf(3);
        assertThat(distance.getValueAsSymbol()).isEqualTo("---");
    }

    @Test
    @DisplayName("add 함수를 통해 계산이 가능하다.")
    void add_함수를_통해_덧셈() {
        final Distance distance = Distance.valueOf(0);
        final Distance result1 = distance.add(1);
        assertThat(result1).isEqualTo(Distance.valueOf(1));
        final Distance result2 = distance.add(Distance.valueOf(1));
        assertThat(result2).isEqualTo(Distance.valueOf(1));
    }
}