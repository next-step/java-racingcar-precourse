package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void setCar(){
        car = new Car("test");
    }

    @Test
    @DisplayName("이름이 제대로 입력 되는지 테스트")
    void getName(){
        assertEquals("test", car.getName());
    }

    @RepeatedTest(100)
    @DisplayName("자동차가 한칸씩 전진하는지 테스트")
    void moveForward_한칸_전진() {
        // given
        int beforeDistance = car.getDistance();
        // when
        car.moveForward();
        // then
        assertTrue(car.getDistance() - beforeDistance == 1 || car.getDistance() == beforeDistance);
    }

    @Test
    @DisplayName("자동차가 한번에 두칸 이상 전진 테스트")
    void moveForward_한번에_두칸_이상_전진(){
        // given
        int beforeDistance = car.getDistance();
        // when
        car.moveForward();
        // then
        assertFalse(car.getDistance() - beforeDistance > 1);

    }

    @Test
    @DisplayName("자동차 여러번 전진 테스트")
    void moveForward_여러번_전진() {
        // given
        int beforeDistance = car.getDistance();
        int repeat = 100;
        // when
        for (int i = 0; i < repeat; i++) {
            car.moveForward();
        }
        // then
        assertTrue(car.getDistance() - beforeDistance >= 0 && car.getDistance() - beforeDistance <= repeat);
    }

}