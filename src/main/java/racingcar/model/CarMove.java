package racingcar.model;

import static racingcar.common.Constants.WIN_BOUNDARY_NUMBER;
import static racingcar.common.Constants.WIN_MOVE_NUMBER;

public class CarMove {
    private int move;

    public CarMove(int move) {
        this.move = move;
    }

    public int getMove() {
        return move;
    }

    public void updateMoveIfWin(int number) {
        if (number >= WIN_BOUNDARY_NUMBER) {
            this.move += WIN_MOVE_NUMBER;
        }
    }

    public Boolean isMaxMove(int maxMove) {
        return this.move > maxMove;
    }
}
