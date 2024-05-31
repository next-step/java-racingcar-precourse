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

}
