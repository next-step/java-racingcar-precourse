package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    @Test
    void 거리_증가() {
        Distance distance = new Distance(0);
        distance.increase();
        assertThat(distance).isEqualTo(new Distance(1));
    }

    @Test
    void 거리_비교() {
        Distance distance = new Distance(3);
        int greaterDistance = distance.getGreaterDistance(1);
        assertThat(greaterDistance).isEqualTo(3);
    }
}