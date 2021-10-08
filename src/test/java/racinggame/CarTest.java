package racinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    void 자동차_객체_생성() {
        assertEquals("자동차 이름은 필수 입니다. 입력해 주세요.", assertThrows(IllegalArgumentException.class, () -> new Car()).getMessage());
    }

    @Test
    void 자동차_이름을_입력하여_객체_생성() {
        Car car = new Car("dony");
        assertEquals(car.getName(), "dony");
    }

    @Test
    void 자동차_이름_길이_오류체크() {
        assertEquals("자동차 이름은 1~5자로 입력해 주세요.", assertThrows(IllegalArgumentException.class, () -> new Car("donydony")).getMessage());
        assertEquals("자동차 이름은 1~5자로 입력해 주세요.", assertThrows(IllegalArgumentException.class, () -> new Car("도니도니도니")).getMessage());
        assertEquals("자동차 이름은 1~5자로 입력해 주세요.", assertThrows(IllegalArgumentException.class, () -> new Car("dony!!")).getMessage());
    }

    @Test
    void 자동차_이름_중복체크() {
        String name = "dony";
        Car car1 = new Car(name);
        Car car2 = new Car(name);
        assertTrue(car1.equals(car2));
    }
}
