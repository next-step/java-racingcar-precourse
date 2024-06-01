package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testConstructor() {
        Car car = new Car("TestCar");

        //생성자로 생성한 Car 객체의 이름과 이동거리가 정상적으로 설정되었는지 확인
        assertEquals("TestCar", car.getName());
        assertEquals(0, car.getDistance());
    }

    @Test
    void testNext() {
        Car car = new Car("TestCar");

        for(int i = 0; i < 1000000; i++) {
            car.next();
        }

        //이동 확률이 60%이므로 대략 600000번 정도 이동해야 함
        assertTrue(car.getDistance() > 500000 && car.getDistance() < 700000);
    }

    @Test
    void testToString() {
        Car car = new Car("TestCar");

        //아무런 이동이 없을 때
        assertEquals("TestCar : ", car.toString());

        //이동이 있을 때
        for(int i = 0; i < 100; i++) {
            car.next();
            assertEquals("TestCar : " + "-".repeat(car.getDistance()), car.toString());
        }
    }
}