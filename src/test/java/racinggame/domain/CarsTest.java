package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {

    @Test
    void 생성() {
        assertDoesNotThrow(() -> new Cars("abc,dg,ef").equals(new Cars("abc,dg,ef")));
    }

    @Test
    void move_테스트() {
        assertDoesNotThrow(() -> {
            Cars cars = new Cars("abc,dg,ef");
            cars.move(() -> true);
        });
    }

    @Test
    void 우승자_확인() {
        Cars cars = new Cars("abc,dg,ef");

        cars.move(() -> true);

        assertEquals(new Cars("abc,dg,ef"), new Cars(cars.winners()));
    }
}