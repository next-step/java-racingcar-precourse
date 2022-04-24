package racingcar.domain.wrapper;

import org.junit.jupiter.api.Test;
import racingcar.exception.RacingException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RacerNameTest {
    @Test
    void 레이서_이름_입력_오류_확인() {
        assertThrows(RacingException.class, () -> new RacerName(null));
        assertThrows(RacingException.class, () -> new RacerName("hello java"));
    }
}
