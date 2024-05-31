import static org.junit.jupiter.api.Assertions.*;

import Model.RacingCarsVO;
import Model.WinnerCalculator;
import java.util.*;
import org.junit.jupiter.api.*;

public class WinnerCalculatorTest {

    @Test
    public void calculateWinners_Solo(){
        RacingCarsVO car1 = new RacingCarsVO("kbm");
        RacingCarsVO car2 = new RacingCarsVO("mbk");
        car1.setMove(4);
        car1.setMove(5);
        car2.setMove(4);
        WinnerCalculator calculator = new WinnerCalculator();
        RacingCarsVO[] cars = new RacingCarsVO[]{car1,car2};
        List<String> winners = calculator.calculateWinners(cars);
        assertEquals(1,winners.size());
        assertTrue(winners.contains("kbm"));
    }
}
