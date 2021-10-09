package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.Cars;
import racinggame.domain.RacingGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    @Test
    void 생성() {
        assertEquals(new RacingGame(new Cars("kdg")), new RacingGame(new Cars("kdg")));
    }

}