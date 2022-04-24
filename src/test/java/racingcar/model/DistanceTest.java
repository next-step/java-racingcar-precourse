package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    private Distance distance;

    @BeforeEach
    void Distance() {
        distance = new Distance();
    }

    @Test
    void 이동_거리_생성_검증() {
        assertThat(distance.getDistance()).isEqualTo(0);
        assertThat(distance.getPosition()).isEqualTo("");
    }

    @Test
    @DisplayName("한 칸 전진할 수 있다.")
    void 전진_거리_검증() {
        distance.increaseDistance();

        assertThat(distance.getDistance()).isEqualTo(1);
        assertThat(distance.getPosition()).isEqualTo("-");
    }
}