package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DistanceTest {
    @Test
    void go_또는_stop_인경우_distnace_변경() {
        Distance distance = new Distance();
        distance.go();
        assertThat(distance.get()).isEqualTo(1);
        distance.go();
        distance.go();
        assertThat(distance.get()).isEqualTo(3);
        distance.stop();
        distance.stop();
        assertThat(distance.get()).isEqualTo(3);
    }

    @Test
    void distance_비교_테스트() {
        Distance distance1 = new Distance();
        Distance distance2 = new Distance();

        distance1.go();
        assertThat(distance1.compare(distance2)).isEqualTo(1);

        distance2.go();
        assertThat(distance1.compare(distance2)).isEqualTo(0);

        distance2.go();
        assertThat(distance1.compare(distance2)).isEqualTo(-1);

    }
}