package racinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundTest {
    @Test
    void 라운드_객체_생성() {
        assertEquals("시도할 횟수는 0보다 커야 합니다.", assertThrows(IllegalArgumentException.class, () -> new Round()).getMessage());
    }

    @Test
    void 라운드_횟수_입력() {
        Round round = new Round(5);
        assertEquals(round.getCount(), 5);
    }

    @Test
    void 라운드_횟수_0입력() {
        assertEquals("시도할 횟수는 0보다 커야 합니다.", assertThrows(IllegalArgumentException.class, () -> new Round(0)).getMessage());
    }
}
