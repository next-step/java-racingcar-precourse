package racingcar.application.port.in;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TotalRaceRound;

class PlayRacingCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"123.0", "-1", "a", "0", "", "1 0"})
    void 예외_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new PlayRacingCommand(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "1", "10"})
    void 총_라운드_수_테스트(String input) {
        assertEquals(new TotalRaceRound(Integer.parseInt(input)), new PlayRacingCommand(input).getTotalRaceRound());
    }

}