package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMoveTest {

    @Test
    @DisplayName("숫자가 4보다 크면 move + 1을 한다")
    void overNumberMoveUp() {
        CarMove carMove = new CarMove(0);
        carMove.updateMoveIfWin(4);

       assertEquals(carMove.getMove(), 1);
    }

    @Test
    @DisplayName("숫자가 4보다 작으면 +1을 하지 않는다")
    void underNumberMoveStop() {
        CarMove carMove = new CarMove(0);
        carMove.updateMoveIfWin(3);

        assertEquals(carMove.getMove(), 0);
    }
}