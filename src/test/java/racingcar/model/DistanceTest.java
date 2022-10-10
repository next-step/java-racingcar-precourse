package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistanceTest {

    private Distance distance;

    @BeforeEach
    void 위치() {
        distance = new Distance();
    }

    @Test
    void 위치_값_생성() {
        assertEquals(distance.getDistance(), 0);
    }

    @Test
    void 위치_값_증가() {
        distance.increase();

        assertEquals(distance.getDistance(), 1);
    }
}
