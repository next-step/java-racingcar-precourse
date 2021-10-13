package racinggame.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {
    @Test
    void 거리_증가_테스트() {
        Distance distance = new Distance();
        distance.moveForward();

        assertThat(distance.getDistance()).isEqualTo(1);
    }
}
