package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("dony");
    }

    @Test
    void 자동차_객체_생성() {
        assertEquals("자동차 이름은 필수 입니다. 입력해 주세요.", assertThrows(IllegalArgumentException.class, () -> new Car()).getMessage());
    }

    @Test
    void 자동차_이름을_입력하여_객체_생성() {
        assertEquals(car.getName(), "dony");
    }

    @Test
    void 자동차_이름_길이_오류체크() {
        assertCarNameLengthOneToFive("donydony");
        assertCarNameLengthOneToFive("도니도니도니");
        assertCarNameLengthOneToFive("dony!!");
    }

    private void assertCarNameLengthOneToFive(String name) {
        assertEquals("자동차 이름은 1~5자로 입력해 주세요.", assertThrows(IllegalArgumentException.class, () -> new Car(name)).getMessage());
    }

    @Test
    void 자동차_이름_중복체크() {
        Car car1 = new Car("dony");
        assertTrue(car.equals(car1));
    }
}
