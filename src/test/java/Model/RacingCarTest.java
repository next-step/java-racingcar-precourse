package test.java.Model;

import Model.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 객체를 할당했을 때 position이 0인지 테스트")
    public void carPositionTest() {
        // given
        Car car = new Car("car1");
        // then
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("자동차가 전진하는지 테스트")
    public void moveTest() {
        // given
        Car car = new Car("car1");
        // when
        int randNum = RandomNumber.generateRanNum();


        if (randNum >= 4) {
            car.move();
            // then
            assertEquals(1, car.getPosition());
        }
        if (randNum < 4) {
            // then
            assertEquals(0, car.getPosition());
        }
    }

    @Test
    @DisplayName("자동차가 전진하면 문자 '-'가 추가되는지 테스트")
    public void toUnitTest() {
        // given
        Car car = new Car("car1");
        car.move();

        assertEquals("-", car.getPosUnits(1));
    }
}
