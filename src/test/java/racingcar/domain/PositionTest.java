package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @ParameterizedTest
    @DisplayName("자동차_위치_증가_체크")
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    void 자동차_위치_증가_체크(int number) {
        Position position = new Position(0);
        for (int count = 0; count < number; count++) {
            position.increasePosition();
        }
        assertThat(position.isEqualPosition(new Position(number))).isTrue();
    }

    @Test
    @DisplayName("자동차_위치_동일한지_체크")
    void 자동차_위치_동일한지_체크() {
        Position position = new Position(1);
        assertThat(position.isEqualPosition(new Position(0))).isFalse();
        assertThat(position.isEqualPosition(new Position(1))).isTrue();
        assertThat(position.isEqualPosition(new Position(2))).isFalse();
    }

    @Test
    @DisplayName("자동차_위치_앞서있는지_체크")
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    void 자동차_위치_앞서있는지_체크() {
        Position position = new Position(1);
        assertThat(position.isFrontPosition(new Position(0))).isTrue();
        assertThat(position.isFrontPosition(new Position(1))).isFalse();
        assertThat(position.isFrontPosition(new Position(2))).isFalse();
    }
}
