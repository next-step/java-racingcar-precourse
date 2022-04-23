package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceTest {

    @DisplayName("이동거리가 증가하면 카운트와 dash 도 증가해야 한다")
    @Test
    void distance_test() {
        Distance distance = new Distance();

        distance.advance();
        distance.advance();
        distance.advance();

        assertThat(distance.getDistanceCount()).isEqualTo(3);
        assertThat(distance.getDistanceByDash()).isEqualTo("---");
    }
}
