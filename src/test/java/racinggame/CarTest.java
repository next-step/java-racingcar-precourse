package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("dony");
    }

    @Test
    void 자동차_객체_생성() {
        assertEquals("[ERROR] 자동차 이름은 필수 입니다. 입력해 주세요.", assertThrows(IllegalArgumentException.class, () -> new Car()).getMessage());
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
        assertCarNameLengthOneToFive(" ");
        assertCarNameLengthOneToFive("");
    }

    private void assertCarNameLengthOneToFive(String name) {
        assertEquals("[ERROR] 자동차 이름은 1~5자로 입력해 주세요.", assertThrows(IllegalArgumentException.class, () -> new Car(name)).getMessage());
    }

    @Test
    void 자동차_이름_중복체크() {
        Car car1 = new Car("dony");
        assertTrue(car.equals(car1));
    }

    @Test
    void 자동차_전진_멈춤() {
        //초기 위치 확인
        assertEquals(car.getPosition(), 0);

        //자동차 전진 멈춤 테스트
        car.move(3); //멈춤
        assertEquals(car.getPosition(), 0);
        car.move(5); //전진
        assertEquals(car.getPosition(), 1);
        car.move(9); //전진
        assertEquals(car.getPosition(), 2);
    }
}
