package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceTest {

    @Test
    void 생성() {
        assertEquals(Distance.of(3), Distance.of(3));
        assertEquals(Distance.of(Distance.of(3)), Distance.of(3));
        assertEquals(Distance.of(3).value(), 3);
    }

    @Test
    void 이동시_거리_하나증가() {
        assertEquals(Distance.move(Distance.of(3)), Distance.of(4));
        assertEquals(Distance.move(Distance.of(3)).value(), Distance.of(4).value());
    }

    @Test
    void 이동거리_증가() {
        assertEquals(Distance.move(Distance.of(3)), Distance.of(4));
    }

    @Test
    void 정렬시_오름차순_검증() {
        List<Distance> distances = Arrays.asList(Distance.of(5), Distance.of(3), Distance.of(4));
        Collections.sort(distances);
        assertEquals(distances, Arrays.asList(Distance.of(3), Distance.of(4), Distance.of(5)));
    }

}