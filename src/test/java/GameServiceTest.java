import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import model.RacingCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.GameService;

public class GameServiceTest {

    GameService gameService = new GameService();

    @Test
    @DisplayName("유효한 자동차 입력 테스트")
    void validCarNameTest() {
        // given
        String[] validCarNames = {"car1", "car2", "car3"};

        // when
        boolean isValid = gameService.validateCarNames(validCarNames);

        // then
        assertTrue(isValid);
    }

    @Test
    @DisplayName("유효하지 않은 자동차 입력 테스트")
    void invalidCarNameTest() {
        // given
        String[] invalidCarNames = {"carName1", "carName2", "carName3"};

        // when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            gameService.validateCarNames(invalidCarNames);
        });

        assertEquals("자동차 이름은 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 리스트 생성 테스트")
    void testCreateCarList() {
        // given
        String[] carNames = {"car1", "car2", "car3"};

        // when
        List<RacingCar> carList = gameService.createCarList(carNames);

        // then
        assertEquals(3, carList.size());
        assertEquals("car1", carList.get(0).getCarName());
        assertEquals("car2", carList.get(1).getCarName());
        assertEquals("car3", carList.get(2).getCarName());
    }
}
