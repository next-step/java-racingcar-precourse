package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("차량 이동 테스트")
    void moveCarTest (){
        //given
        var movedCar = new Car("Move");
        var stoppedCar = new Car("Stop");
        //when
        movedCar.move(4);
        stoppedCar.move(2);
        //then
        assertEquals(movedCar.getPosition(), 1);
        assertEquals(stoppedCar.getPosition(), 0);

    }
    @Test
    @DisplayName("잘못된 길이의 차량 이름 길이 테스트")
    void wrongCarNameTest (){
        //given
        final String carName = "666666";
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> new Car(carName));
    }
}