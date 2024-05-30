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

    @Test
    @DisplayName("자동차 이름이 5자 이상이면 유효하지 않다.")
    public void isInValidName() throws Exception {
        //given
        String name = "stopmin";

        //when
        boolean isValid = Car.isValidName(name);

        //then
        assertFalse(isValid);
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하면 유효하다.")
    public void isValidName() throws Exception {
        //given
        String name = "min";

        //when
        boolean isValid = Car.isValidName(name);

        //then
        assertTrue(isValid);
    }
}
