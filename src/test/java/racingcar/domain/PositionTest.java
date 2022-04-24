package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    private Position position;

    @BeforeEach
    void setup() {
        position = new Position();
    }

    @Test
    void 위치의_초기값은_0() {
        assertThat(position.getValue()).isEqualTo(0);
    }


    @ParameterizedTest
    @ValueSource(ints = {5, 7})
    void 위치는_1씩_증가한다(int count) {
        for (int i = 0; i < count; i++) {
            position.increase();
        }

        assertThat(position.getValue()).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 7})
    void 위치비교_동등성확인(int count) {
        Position anotherPosition = new Position();
        for (int i = 0; i < count; i++) {
            position.increase();
            anotherPosition.increase();
        }

        assertThat(position).isEqualTo(anotherPosition);
    }
}
