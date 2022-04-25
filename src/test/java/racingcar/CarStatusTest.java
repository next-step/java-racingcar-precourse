package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarStatusTest {

    @Test
    void is_go() {
        assertEquals(CarStatus.GO, CarStatus.from(4));
    }

    @Test
    void is_stop() {
        assertEquals(CarStatus.STOP, CarStatus.from(3));
    }

}