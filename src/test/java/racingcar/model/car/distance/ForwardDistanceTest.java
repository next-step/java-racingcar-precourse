package racingcar.model.car.distance;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.distance.ForwardDistance;
import racingcar.model.car.distance.Rpm;

public class ForwardDistanceTest {

    @Test
    @DisplayName("한 번도 전진 안했을 시 빈 문자열 ")
    void 전진_안한경우_DISTANCE_길이는_0() {
        ForwardDistance distance = new ForwardDistance();
        assertThat(distance.distance()).isEqualTo("");

    }

    @Test
    @DisplayName("두 번 전진 시 -- ")
    void 두_번_전진시_DISTANCE_길이는_2() {
        ForwardDistance distance = new ForwardDistance(2);
        assertThat(distance.distance()).isEqualTo("--");
    }

    @Test
    @DisplayName("다섯 번 전진 시 ----- ")
    void 다섯_번_전진시_DISTANCE_길이는_5() {
        ForwardDistance distance = new ForwardDistance(5);
        assertThat(distance.distance()).isEqualTo("-----");
    }

    @Test
    @DisplayName("세 번 전진한 거리와 두 번 전진한 거리 비교")
    void 세_번_전진한_거리가_두_번_전진한_거리보다_멀다() {
        ForwardDistance origin = new ForwardDistance(3);
        ForwardDistance target = new ForwardDistance(2);

        assertThat(origin.isLongerThan(target)).isTrue();
    }

    @Test
    @DisplayName("동일한 거리 전진한 경우 거리 비교")
    void 동일거리_전진에대한_비교시_TRUE_반환_테스트() {
        ForwardDistance origin = new ForwardDistance(2);
        ForwardDistance target = new ForwardDistance(2);
        assertThat(origin.isSameDistanceWith(target)).isTrue();
    }
}
