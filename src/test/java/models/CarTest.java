package models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("random number가 4 이상일 때만 차가 앞으로 전진하는지 테스트")
    public void testCarMove() {
        Car car = new Car("test");
        car.move(4);
        assertEquals(1, car.getPosition());
        car.move(3);
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("차의 이름을 잘 가져오는지 테스트")
    public void testGetCarName() {
        Car car = new Car("test");
        assertEquals("test", car.getName());
    }

    @Test
    @DisplayName("차의 현재 위치를 잘 가져오는지 테스트")
    public void testGetPosition() {
        Car car = new Car("test");
        car.move(5);
        car.move(7);
        car.move(2);
        assertEquals(2, car.getPosition());
    }

}
