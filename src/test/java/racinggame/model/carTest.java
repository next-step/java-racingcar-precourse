package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class carTest {
    @Test
    @DisplayName("자동차_이동여부_판단")
    void 전진() {
        assertThat(Car.move(9)).isEqualTo(CarStatus.GO);
        assertThat(Car.move(4)).isEqualTo(CarStatus.GO);
        assertThat(Car.move(3)).isEqualTo(CarStatus.STOP);
        assertThat(Car.move(1)).isEqualTo(CarStatus.STOP);
    }
}
