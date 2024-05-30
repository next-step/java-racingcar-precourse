package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다.")
    public void createCar() throws Exception {
        //given
        Car car = new Car("stopmin");

        //when
        String name = car.getName();

        //then
        assertEquals("stopmin", name);
    }

    @Test
    @DisplayName("자동차가 전진하는지 확인한다.")
    public void moveForward() throws Exception {
        //given
        Car car = new Car("stopmin");

        //when
        car.moveForward();
        int position = car.getPosition();

        //then
        assertEquals(1, position);
    }
}
