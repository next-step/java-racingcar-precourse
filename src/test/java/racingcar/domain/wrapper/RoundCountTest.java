package racingcar.domain.wrapper;

import org.junit.jupiter.api.Test;
import racingcar.exception.RacingException;

import static org.junit.jupiter.api.Assertions.*;

class RoundCountTest {

    @Test
    void 유효_범위_확인() {
        assertThrows(RacingException.class,() -> new RoundCount("H"));
        assertThrows(RacingException.class,() -> new RoundCount("0"));
    }
}