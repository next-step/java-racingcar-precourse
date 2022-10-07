package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 이름_입력_길이() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> new Car("이름길이5글자초과"));
    }

    @Test
    void 이름_입력_Null() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
    }

    @Test
    void 이름_입력_빈값() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }

    @Test
    void 경주시도횟수_입력_숫자() throws IllegalArgumentException {
        Car car = new Car("1");
        car.setMoveCount();
        assertThrows(IllegalArgumentException.class, () -> new Car("이름길이5글자초과"));
    }

    @Test
    void 전진() {
        Car car = new Car("car1");
        car.move(5);
        assertEquals("-", car.getRaceStatus());
    }

    @Test
    void 멈춤() {
        Car car = new Car("car1");
        car.move(3);
        assertEquals("", car.getRaceStatus());
    }

}
