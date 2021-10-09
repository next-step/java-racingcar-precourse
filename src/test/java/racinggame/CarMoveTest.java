package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarMoveTest {
    private CarMove carMove;

    @BeforeEach
    void setUp() {
        carMove = new CarMove();
    }

    @Test
    void 자동차_이동() {
        assertTrue(carMove.getMoveStatus(3) == MoveStatus.STOP);
        assertTrue(carMove.getMoveStatus(4) == MoveStatus.MOVE);
        assertTrue(carMove.getMoveStatus(9) == MoveStatus.MOVE);
    }
}
