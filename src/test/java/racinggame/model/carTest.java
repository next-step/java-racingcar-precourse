package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class carTest {
    @Test
    @DisplayName("자동차_이동여부_판단")
    void 전진() {
        assertThat(Car.isMove(9)).isTrue();
        assertThat(Car.isMove(4)).isTrue();
        assertThat(Car.isMove(3)).isFalse();
        assertThat(Car.isMove(10)).isFalse();
    }
}
