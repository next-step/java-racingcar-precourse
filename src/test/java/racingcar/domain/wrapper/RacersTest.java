package racingcar.domain.wrapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacersTest {
    @Test
    void 가장_멀리_이동한_거리() {
        Racers racers = new Racers("chan,jun");

        Racer racer = racers.getRacers().get(0);
        racer.move(7L);

        Racer racer2 = racers.getRacers().get(1);
        racer2.move(7L);
        racer2.move(7L);

        assertEquals(2, racers.getMaxInstance());
    }
}
