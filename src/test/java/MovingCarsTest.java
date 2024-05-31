import static org.junit.jupiter.api.Assertions.*;

import Model.MovingCars;
import Model.RacingCarsVO;
import View.RacingViews;
import org.junit.jupiter.api.*;

public class MovingCarsTest {

    private MovingCars movingCars;
    private RacingViews racingViews;

    @BeforeEach
    @DisplayName("테스트 실행 전에 필요한 초기 설정 작성 및 일관되게 수행하기 위해 사용")
    public void setUp(){
        racingViews = new RacingViews();
        movingCars = new MovingCars(racingViews,new CustomRandom(5));
    }

    @Test
    @DisplayName("movingCar의 실행 후 움직였는지 확인")
    public void movingCarTest(){
        RacingCarsVO car1 = new RacingCarsVO("kbm");
        RacingCarsVO car2 = new RacingCarsVO("mbk");
        RacingCarsVO[] cars = new RacingCarsVO[]{car1, car2};
        movingCars.movingCar(cars, 3);
        assertEquals(3, car1.getMove());
        assertEquals(3, car2.getMove());
    }

}
