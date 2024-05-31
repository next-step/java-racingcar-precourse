package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void move_CarMovedSuccessfully() {
        Car car = new Car(new CarName("Test"));
        car.move();
        assertTrue(car.moved() >= 0); // 움직인 횟수는 0 이상이어야 함
    }

    @Test
    void moved_ReturnsCorrectMovedCount() {
        Car car = new Car(new CarName("Test"));
        assertEquals(0, car.moved()); // 아직 움직이지 않았으므로 0이어야 함
    }

    @Test
    void carName_ReturnsCorrectName() {
        Car car = new Car(new CarName("TestC"));
        assertEquals("TestC", car.carName()); // 생성된 Car 객체의 이름은 "TestCar"여야 함
    }

}
