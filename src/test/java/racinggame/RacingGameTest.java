package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.Cars;
import racinggame.domain.strategy.MoveStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    private final MoveStrategy moveStrategy = () -> true;

    @Test
    void 생성() {
        assertEquals(new RacingGame(moveStrategy, new Cars("kdg")), new RacingGame(moveStrategy, new Cars("kdg")));
    }

}