package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void 전진하기() {
        Position position = new Position();
        position.moveForward();
        assertThat(position.getValue()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "10,10", "100,100"})
    void n번_전진하기(int count, int expected) {
        Position position = new Position();
        for (int i = 0; i < count; i++) {
            position.moveForward();
        }
        assertThat(position.getValue()).isEqualTo(expected);
    }

}