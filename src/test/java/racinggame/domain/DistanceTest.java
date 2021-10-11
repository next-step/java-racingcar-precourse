package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DistanceTest {

    private Distance distance;

    @BeforeEach
    void Distance() {
        distance = new Distance();
    }

    @Test
    @DisplayName("생성할 수 있다.")
    void create() {
        assertThat(distance.getDistance()).isEqualTo(0);
        assertThat(distance.getPosition()).isEqualTo("");
    }

    @Test
    @DisplayName("한 칸 전진할 수 있다.")
    void go_distance() {
        distance.increaseDistance();

        assertThat(distance.getDistance()).isEqualTo(1);
        assertThat(distance.getPosition()).isEqualTo("-");
    }
}