import static org.junit.jupiter.api.Assertions.*;

import Model.RacingCarsVO;
import org.junit.jupiter.api.*;

public class RacingCarsVOTest {

    @Test
    @DisplayName("객체 생성에 대한 테스트")
    public void RacinvCarsVO_InitializationTest(){
        RacingCarsVO car = new RacingCarsVO("kbm");
        assertEquals("kbm",car.getCarName());
        assertEquals(0,car.getMove());
    }

    @Test
    @DisplayName("인자 값이 4이상이면 move가 증가하는지에 대한 테스트")
    public void setMoveIncrease(){
        RacingCarsVO car = new RacingCarsVO("kbm");
        car.setMove(4);
        assertEquals(1,car.getMove());
    }

    @Test
    @DisplayName("인자 값이 4미만이면 move가 그대로인지에 대한 테스트")
    public void setMoveNotIncrease(){
        RacingCarsVO car = new RacingCarsVO("kbm");
        car.setMove(3);
        assertEquals(0,car.getMove());
    }

    @Test
    @DisplayName("toString()에 대한 테스트")
    public void toStringTest(){
        RacingCarsVO car = new RacingCarsVO("kbm");
        car.setMove(7);
        car.setMove(2);
        car.setMove(4);
        assertEquals("kbm : --",car.toString());
    }
}
