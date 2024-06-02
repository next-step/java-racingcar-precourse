import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayInputStream;
import java.util.List;
import model.RacingCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.GameService;

public class GameServiceTest {

    GameService gameService = new GameService();

    @Test
    @DisplayName("유효한자동차입력테스트")
    public void validGetCarNamesTest() {
        //given
        String input = "car1,car2,car3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        List<RacingCar> carList = gameService.getCarNames();

        //then
        assertNotNull(carList);
        assertEquals(3, carList.size());
        assertEquals("car1", carList.get(0).getCarName());
        assertEquals("car2", carList.get(1).getCarName());
        assertEquals("car3", carList.get(2).getCarName());
    }
}
