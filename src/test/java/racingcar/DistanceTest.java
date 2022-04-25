package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {

    @Test
    @DisplayName("초기에 생성된 거리는 0이다.")
    void createDistance() {
        Distance distance = Distance.createDistance();
        assertThat(distance.getCurrentDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("전진하면 거리는 1씩 증가한다.")
    void goForward() {
        Distance distance0 = Distance.createDistance();
        assertThat(distance0.getCurrentDistance()).isEqualTo(0);
        Distance distance1 = distance0.goForward();
        assertThat(distance1.getCurrentDistance()).isEqualTo(1);
        Distance distance2 = distance1.goForward();
        assertThat(distance2.getCurrentDistance()).isEqualTo(2);
    }
}