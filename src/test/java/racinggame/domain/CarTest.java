package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarTest {

    @Test
    void 생성() {
        assertDoesNotThrow(() -> new Car("abc").equals(new Car("abc")));
    }

    @Test
    void 움직이는_경우() {
        assertDoesNotThrow(() -> {
            Car car = new Car("abc");
            car.move(() -> true);
        });
    }
}