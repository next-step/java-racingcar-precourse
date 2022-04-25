package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.utils.TestCarsUtils.testRounds;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CumulativeRoundsTest {

    @Test
    @DisplayName("누계 일급 객체 생성 테스트")
    void init() {
        // given
        final Rounds rounds = testRounds();
        rounds.startAll();

        // when & then
        assertDoesNotThrow(() -> new CumulativeRounds(rounds));
    }

    @Test
    @DisplayName("누계 일급 객체 생성 실패 테스트")
    void init_exception() {
        // given

        // when & then
        assertThatThrownBy(() -> new CumulativeRounds(testRounds()))
                .isInstanceOf(IllegalStateException.class);
    }
}