package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차이름_정상() {
        assertDoesNotThrow(() -> new Car("kang"));
    }

    @Test
    void 자동차이름_5글자초과() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Car("kanguk"));
        assertEquals("자동차 이름은 1자 이상, 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    void 자동차이름_공백() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Car(""));
        assertEquals("자동차 이름은 1자 이상, 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    void 자동차전진_4이상() {
        Car car = new Car("pobi");
        car.move(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    void 자동차전진_3이하() {
        Car car = new Car("pobi");
        car.move(3);
        assertEquals(0, car.getPosition());
    }

}