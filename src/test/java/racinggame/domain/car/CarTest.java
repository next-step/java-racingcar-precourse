package racinggame.domain.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racinggame.domain.car.Car;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void 차_이름_길이_테스트() {
        assertTrue(Car.isAvailableCarName("test"));
        assertFalse(Car.isAvailableCarName("test23"));
    }

    @Test
    void 차_이동_테스트() {
        assertFalse(Car.canMoveCarByNum(0));
        assertFalse(Car.canMoveCarByNum(-1));
        assertFalse(Car.canMoveCarByNum(10));
        assertTrue(Car.canMoveCarByNum(4));
        assertTrue(Car.canMoveCarByNum(9));
    }


}
