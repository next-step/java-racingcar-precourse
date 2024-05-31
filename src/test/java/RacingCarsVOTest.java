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

}
