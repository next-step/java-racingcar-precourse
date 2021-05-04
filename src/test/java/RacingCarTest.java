import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    RacingCar game;

    @BeforeEach
    void setUp() {
        game = new RacingCar();
    }

    @Test
    void carNameParseTest() {
        String[] carNames;
        try {
            carNames = game.parseCarNames("a,b,c");
            assertTrue(carNames.length == 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void randomNumberTest() {
        int random = game.generateRandomNumber();
        assertTrue(0 <= random && random >= 9);
    }

}
