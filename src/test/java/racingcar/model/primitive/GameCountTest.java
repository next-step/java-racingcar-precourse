package racingcar.model.primitive;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameCountTest {


    @ParameterizedTest
    @CsvSource(value = {"1,1", "3,3"})
    void initGameCountAndCheckValue(int input, int expected) {
        GameCount gameCount = new GameCount(input);
        assertThat(gameCount.getValue()).isEqualTo(expected);
    }
}