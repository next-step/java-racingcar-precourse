import static org.junit.jupiter.api.Assertions.*;

import Model.RacingCarsVO;
import Model.WinnerCalculator;
import java.util.*;
import org.junit.jupiter.api.*;

public class WinnerCalculatorTest {

    @Test
    @DisplayName("우승자가 혼자인 경우에 대한 테스트")
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

    @Test
    @DisplayName("우승자가 여러 명인 경우에 대한 테스트")
    public void calculateWinners_Multi(){
        RacingCarsVO car1 = new RacingCarsVO("kbm");
        RacingCarsVO car2 = new RacingCarsVO("mbk");
        RacingCarsVO car3 = new RacingCarsVO("bmk");
        car1.setMove(5);
        car3.setMove(5);
        WinnerCalculator calculator = new WinnerCalculator();
        RacingCarsVO[] cars = new RacingCarsVO[]{car1,car2,car3};
        List<String> winners = calculator.calculateWinners(cars);
        assertEquals(2,winners.size());
        assertTrue(winners.contains("kbm"));
        assertTrue(winners.contains("bmk"));
    }
}
