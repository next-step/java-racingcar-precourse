package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DistanceTest {

    @Test
    public void Distance는_숫자필드를_가진다() {
        Distance distance = new Distance(5);
        Assertions.assertThat(distance.getDistance()).isEqualTo(5);
    }
}
