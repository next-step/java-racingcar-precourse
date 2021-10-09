package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarsTest {

    @Test
    void 생성() {
        assertDoesNotThrow(() -> new Cars("abc,dg,ef").equals(new Cars("abc,dg,ef")));
    }

    @Test
    void moves() {
        assertDoesNotThrow(() -> {
            Cars cars = new Cars("abc,dg,ef");
            cars.move(() -> true);
        });
    }
}