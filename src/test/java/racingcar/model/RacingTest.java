package racingcar.model;

import org.junit.jupiter.api.Test;

public class RacingTest {

    @Test
    public void racingTest() {
        Racing racingCars = new Racing("pobi,endrw,tomas");
        racingCars.moveCheck();
    }
}
