package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @DisplayName("move 여부 결정 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, false", "3, false", "4, true", "5, true", "2, false"})
    void determineGoOrNot_4미만은_false_4이상은_true(int num, boolean expected) {
       boolean actual = Players.determineGoOrNot(num);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
