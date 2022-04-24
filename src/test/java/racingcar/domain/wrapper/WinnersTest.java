package racingcar.domain.wrapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {

    @Test
    void 단독_우승자_확인() {
        Winners winners = new Winners();
        winners.add("jun");

        assertEquals("jun", winners.getWinners());
    }

    @Test
    void 공동_우승자_확인() {
        Winners winners = new Winners();
        winners.add("jun");
        winners.add("chan");

        assertEquals("jun, chan", winners.getWinners());
    }
}