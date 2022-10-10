package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @DisplayName("Position 객체 생성 및 이동 테스트")
    @Test
    void set() {
        Position position = new Position();
        position.move();
        assertThat(position).isEqualTo(new Position(1));
    }

    @DisplayName("Position 크기 비교 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,false", "2,1,true", "1,1,true"}, delimiter = ',')
    void compare(int position, int position2, boolean expected) {
        Position pos = new Position(position);
        Position pos2 = new Position(position2);
        assertThat(pos.isBiggerPosition(pos2)).isEqualTo(expected);
    }
}
