package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Round;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RoundTest {
    @Test
    void 횟수_예외_글자() {
        assertThrows(IllegalArgumentException.class, () -> {
            String count = "예외사항";
            Round round = new Round();
            round.generateRound(count);
        });
    }
}
