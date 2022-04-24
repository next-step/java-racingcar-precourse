package racingcar.domain.wrapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    @Test
    void 이동() {
        Location location = new Location();
        location.moveForward();

        assertEquals(1, location.getDistance());
        assertEquals("-", location.getDashDistance());
    }

}