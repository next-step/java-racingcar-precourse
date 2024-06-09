import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import Model.RacingGameCar;

public class RacingGameCarTest {

    @Test
    public void testForwardingCar() {
        RacingGameCar car = new RacingGameCar("TestCar", 0);
        car.forwardingCar();
        assertEquals(1, car.getForward());
    }
}