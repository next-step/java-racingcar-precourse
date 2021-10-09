package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.CarMove;
import racinggame.domain.MoveStatus;

import static org.junit.jupiter.api.Assertions.assertSame;

public class CarMoveTest {

    @Test
    void 자동차_이동() {
        assertSame(CarMove.getMoveStatus(3), MoveStatus.STOP);
        assertSame(CarMove.getMoveStatus(4), MoveStatus.MOVE);
        assertSame(CarMove.getMoveStatus(9), MoveStatus.MOVE);
    }
}
