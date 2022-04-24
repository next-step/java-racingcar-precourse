package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    void 자동차_전진() {
        Car car = new Car("hello");
        car.doRound(5);
        assertEquals(car.getPosition(), 1);
    }

    @Test
    void 자동차_멈춤() {
        Car car = new Car("hello");
        car.doRound(3);
        assertEquals(car.getPosition(), 0);
    }

    @Test
    void 자동차_전진후_상태() {
        Car car = new Car("hello");
        car.doRound(5);
        assertEquals(car.getCurrentStatus(), "hello : -");
    }
}
