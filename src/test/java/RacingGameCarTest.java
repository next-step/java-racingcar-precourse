import Model.RacingGameCar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameCarTest {

    @Test
    public void testForwardingCar() {
        RacingGameCar car = new RacingGameCar("TestCar", 3);
        car.forwardingCar();
        assertEquals(4, car.getForward());
    }

    @Test
    public void testToString() {
        RacingGameCar car = new RacingGameCar("TestCar", 5);
        assertEquals("TestCar : -----", car.toString());
    }
}