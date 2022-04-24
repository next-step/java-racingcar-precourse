package racingcar.domain.wrapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacerTest {
    private static Racer racer;

    @BeforeAll
    static void beforeAll() {
        racer = new Racer("jun");
        racer.move(7L);
        racer.move(7L);
        racer.move(7L);
    }

    @Test
    void 이동_거리_계산() {
        assertEquals(3, racer.maxInstance(2));
    }

    @Test
    void 우승자() {
        assertEquals("jun", racer.getWinnerName(3));
    }
}
