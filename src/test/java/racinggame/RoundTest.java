package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Round;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundTest {
    private Round round;

    @BeforeEach
    void setUp() {
        round = new Round(5);
    }

    @Test
    void 라운드_객체_생성() {
        assertEquals("[ERROR] 시도할 횟수는 0보다 커야 합니다.", assertThrows(IllegalArgumentException.class, () -> new Round()).getMessage());
    }

    @Test
    void 라운드_횟수_입력() {
        assertEquals(round.getCount(), 5);
    }

    @Test
    void 라운드_횟수_0입력() {
        assertEquals("[ERROR] 시도할 횟수는 0보다 커야 합니다.", assertThrows(IllegalArgumentException.class, () -> new Round(0)).getMessage());
    }

    @Test
    void 라운드_횟수_차감() {
        round.decreaseCount();
        assertEquals(round.getCount(), 4);
        round.decreaseCount();
        assertEquals(round.getCount(), 3);
    }

    @Test
    void 남은_라운드_확인하기() {
        round.decreaseCount();
        round.decreaseCount();
        round.decreaseCount();
        round.decreaseCount();
        round.decreaseCount();
        assertEquals(round.isRemainRound(), false);
    }
}
