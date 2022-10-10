package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpotTest {
    @Test
    void defaultSpotShouldBe1() {
        Spot actual = new Spot();
        Spot expected = new Spot(0);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldMove1() {
        Spot spot = new Spot();
        Spot actual = spot.move();
        Spot expected = new Spot(1);
        assertThat(actual).isEqualTo(expected);
    }
}
