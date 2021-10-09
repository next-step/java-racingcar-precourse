package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceTest {

    @Test
    void 생성() {
        assertEquals(Distance.of(3), Distance.of(3));
    }

    @Test
    void 이동거리_증가() {
        assertEquals(Distance.move(Distance.of(3)), Distance.of(4));
    }

}