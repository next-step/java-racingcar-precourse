package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("Car 객체 생성시 이름이 알맞게 설정되고 move가 0부터 시작이 되는지 확인")
    public void testCarInit(){
        Car car = new Car("testcar");
        assertEquals("testcar",car.getCarname());
        assertEquals(0,car.getMove());

    }
    @Test
    @DisplayName("자동차의 move가 파라미터로 전달된 랜덤값에 따라 잘 작동되는지 확인")
    public void testCarMove(){
        Car car = new Car("testCar");
        car.moveCar(4);
        assertEquals(1,car.getMove());
        car.moveCar(1);
        assertEquals(1,car.getMove()); // 4보다 작은 값이 들어갔기때문에 이동 X
    }

}