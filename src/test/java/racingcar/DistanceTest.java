package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {
    @Test
    void testInitialValue() {
        Distance distance = new Distance();
        assertThat(distance.toInt()).isEqualTo(0);
    }

    @Test
    void testIncrement() {
        Distance distance = new Distance();
        distance.inc();
        assertThat(distance.toInt()).isEqualTo(1);
        distance.inc();
        distance.inc();
        assertThat(distance.toInt()).isEqualTo(3);
    }

    @Test
    void testToString() {
        Distance distance = new Distance();
        assertThat(distance.toString()).isEqualTo("");
        distance.inc();
        assertThat(distance.toString()).isEqualTo("-");
        distance.inc();
        distance.inc();
        assertThat(distance.toString()).isEqualTo("---");
    }
}
