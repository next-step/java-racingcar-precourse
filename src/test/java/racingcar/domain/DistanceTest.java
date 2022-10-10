package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.Number;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    @DisplayName("거리를 1증가 시킨다")
    @Test
    void 거리를_1증가_시킨다() {
        // given
        Distance distance = new Distance(Number.ZERO);

        // when
        // then
        distance.increase();
        assertThat(distance.getDistance()).isEqualTo(1);

        distance.increase();
        assertThat(distance.getDistance()).isEqualTo(2);
    }

    @DisplayName("거리가 target 보다 더 큰지 체크한다")
    @Test
    void 거리가_target_보다_더_큰지_체크한다() {
        // given
        // when
        // then
        assertThat(new Distance(1).isMoveMoreThen(new Distance(2))).isFalse();
        assertThat(new Distance(2).isMoveMoreThen(new Distance(1))).isTrue();
    }

    @DisplayName("거리가 target 과 같은지 체크한다")
    @Test
    void 거리가_target_과_같은지_체크한다() {
        // given
        // when
        // then
        assertThat(new Distance(1).isSameDistance(new Distance(1))).isTrue();
        assertThat(new Distance(2).isSameDistance(new Distance(2))).isTrue();
        assertThat(new Distance(10).isSameDistance(new Distance(10))).isTrue();
        assertThat(new Distance(2).isSameDistance(new Distance(10))).isFalse();
    }
}