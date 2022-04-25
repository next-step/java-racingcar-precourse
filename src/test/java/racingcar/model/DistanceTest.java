package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {
    @Test
    @DisplayName("이동 거리가 증가하면 distance 필드가 1 증가한다.")
    void increase() {
        Distance distance = new Distance();
        distance.increase();
        assertThat(distance.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동 거리를 리턴한다.")
    void get() {
        Distance distance = new Distance();
        assertThat(distance.getDistance()).isEqualTo(0);
    }
}
