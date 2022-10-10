package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.Constants;
import racingcar.utils.RandomGenerator;

public class CarPositionTest {
    @Test
    void carPositionTest() {
        CarPosition carPosition = new CarPosition();
        Assertions.assertEquals(Constants.DEFAULT_CAR_POSITION, carPosition.getCarPosition());
    }

    @Test
    void fixedCarPositionTest() {
        CarPosition carPosition = new CarPosition(Constants.CAR_MOVING_AMOUNT);
        Assertions.assertEquals(Constants.CAR_MOVING_AMOUNT, carPosition.getCarPosition());    }
}
