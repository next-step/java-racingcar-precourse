package racinggame.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    void 위치_전진() {
        Position position = new Position();
        Position expectedPosition = new Position(1);

        position.forward();

        assertThat(position).isEqualTo(expectedPosition);
        assertThat(position.getValue()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:-----", "3:---", "1:-"}, delimiter = ':')
    void 위치_하이픈_변환(int forwardValue, String expectedValue) {
        Position position = new Position(forwardValue);

        assertThat(position.convertToHyphen()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:true", "4:false"}, delimiter = ':')
    void 동일_위치(int positionValue, boolean expectedValue) {
        Position position = new Position(3);
        Position comparePosition = new Position(positionValue);

        assertThat(position.equals(comparePosition)).isEqualTo(expectedValue);
    }

}
