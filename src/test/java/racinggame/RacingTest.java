package racinggame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import racinggame.model.CarDistance;

public class RacingTest extends NSTest {
	private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    
	private static final String ERROR_MESSAGE = "[ERROR]";
	
	@BeforeEach
    void beforeEach() {
        setUp();
    }
	
	@Test
	void 랜덤값_확인() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(3, 5) ;
            CarDistance car = new CarDistance();
            car.moveOrStop();
            car.moveOrStop();
    		
    		car.getCarDistance();
    		
            assertEquals(car.getCarDistance(), "-");
        }
	}
	
	@Test
	void 정상진행_확인() {
		assertRandomTest(() -> {
            run("pobi,woni", "3");
            verify(
            		"pobi : -", "woni : ", 
            		"pobi : -", "woni : -",
            		"pobi : --", "woni : -",
            		"최종 우승자는 pobi,woni 입니다."
            		);
        }, 
				MOVING_FORWARD, STOP, 
				STOP, MOVING_FORWARD,
				MOVING_FORWARD, MOVING_FORWARD
				);
	} 
	
	@AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
