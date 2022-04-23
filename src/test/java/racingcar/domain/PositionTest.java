package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PositionTest {
    @DisplayName("포지션 전진 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:2", "3:3"}, delimiter = ':')
    void positionAdvanceTest(int num, int expect) {
        Position position = new Position();
        for (int i = 0; i < num; i++) {
            position.advance();
        }
        assertThat(position.getPosition()).isEqualTo(expect);
    }
}
